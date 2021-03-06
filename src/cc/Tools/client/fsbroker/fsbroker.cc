/*
 * Copyright (C) 2007-2016 Hypertable, Inc.
 *
 * This file is part of Hypertable.
 *
 * Hypertable is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or any later version.
 *
 * Hypertable is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

#include <Common/Compat.h>

#include "CommandInterpreter.h"

#include <Hypertable/Lib/Config.h>

#include <FsBroker/Lib/Config.h>

#include <Tools/Lib/CommandShell.h>

#include <AsyncComm/Comm.h>

#include <Common/Error.h>
#include <Common/Init.h>
#include <Common/Properties.h>
#include <Common/Usage.h>

#include <boost/algorithm/string.hpp>
#include <boost/thread/condition.hpp>
#include <boost/thread/mutex.hpp>

#include <cstring>
#include <iostream>
#include <vector>

extern "C" {
#include <editline/readline.h>
}

using namespace Hypertable;
using namespace Tools::client;
using namespace Config;
using namespace std;

namespace {

  const char *usage =
    "\n"
    "Usage: ht_fsbroker [options] <host>[:<port>]\n\nOptions"
    ;

  struct AppPolicy : Policy {
    static void init_options() {
      cmdline_desc(usage).add_options()
        ("nowait", "Don't wait for certain commands to complete (e.g. shutdown)")
        ("output-only", "Display status output and exit with status 0")
        ;
      cmdline_hidden_desc().add_options()
      ("address", str(), "")
      ("address", -1);
    }
    static void init() {
      if (has("address")) {
        Endpoint e = InetAddr::parse_endpoint(get_str("address"));
        properties->set("FsBroker.Host", e.host);
        if (e.port)
          properties->set("FsBroker.Port", e.port);
      }
    }
  };

  typedef Meta::list<CommandShellPolicy, FsClientPolicy,
                     DefaultCommPolicy, AppPolicy> Policies;

}


int main(int argc, char **argv) {
  int error = 1;
  bool silent {};
  bool output_only {};

  try {
    init_with_policies<Policies>(argc, argv);
    InetAddr addr;
    
    String host = get_str("FsBroker.Host");
    ::uint16_t port = get_i16("FsBroker.Port");
    ::uint32_t timeout_ms  = properties->get_pref<int32_t>({"FsBroker.Timeout", "timeout"});

    bool nowait = has("nowait");
    output_only = has("output-only");
    silent = has("silent") && get_bool("silent");


    InetAddr::initialize(&addr, host.c_str(), port);

    DispatchHandlerSynchronizer *sync_handler = new DispatchHandlerSynchronizer();
    DispatchHandlerPtr default_handler(sync_handler);
    EventPtr event;
    Comm *comm = Comm::instance();

    if ((error = comm->connect(addr, default_handler)) != Error::OK) {
      if (!silent)
        cout << "FsBroker CRITICAL - " << Error::get_text(error) << endl;
      quick_exit(output_only ? 0 : 2);
    }

    /// this should have a deadline
    if (!sync_handler->wait_for_connection()) {
      if (!silent)
        cout << "FsBroker CRITICAL - connect error" << endl;
      quick_exit(output_only ? 0 : 2);
    }

    FsBroker::Lib::ClientPtr client = make_shared<FsBroker::Lib::Client>(comm, addr, timeout_ms);

    CommandInterpreterPtr interp = make_shared<fsbroker::CommandInterpreter>(client, nowait);

    CommandShellPtr shell = make_shared<CommandShell>("fsbroker", "FsBroker", interp, properties);

    error = shell->run();
  }
  catch (Exception &e) {
    if (!silent) {
      cout << "FsBroker CRITICAL - " << Error::get_text(e.code());
      const char *msg = e.what();
      if (msg && *msg)
        cout << " - " << msg;
      cout << endl;
    }
    quick_exit(output_only ? 0 : 2);
  }
  quick_exit(error);
}

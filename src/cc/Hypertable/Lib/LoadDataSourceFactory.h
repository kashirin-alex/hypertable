/* -*- c++ -*-
 * Copyright (C) 2007-2016 Hypertable, Inc.
 *
 * This file is part of Hypertable.
 *
 * Hypertable is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 3 of the
 * License, or any later version.
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

#ifndef HYPERTABLE_LOADDATASOURCEFACTORY_H
#define HYPERTABLE_LOADDATASOURCEFACTORY_H

#include "Common/String.h"

#include "LoadDataSource.h"
#include "FsBroker/Lib/Client.h"

namespace Hypertable {

  class LoadDataSourceFactory {

  public:

    static LoadDataSource *create(FsBroker::Lib::ClientPtr &dfs_client,
                                  const std::string &fname, const int src,
                                  const std::string &header_fname, const int header_src,
                                  const std::vector<String> &key_columns,
                                  const std::string &timestamp_column,
                                  char field_separator,
                                  int row_uniquify_chars,
                                  int load_flags
                                  );
  };

} // namespace Hypertable

#endif // HYPERTABLE_LOADDATASOURCEFACTORY_H

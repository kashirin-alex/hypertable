/**
 * Copyright (C) 2007-2012 Hypertable, Inc.
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

package org.hypertable.DfsBroker.hadoop;

import java.net.ProtocolException;
import java.util.logging.Logger;
import org.hypertable.AsyncComm.ApplicationHandler;
import org.hypertable.AsyncComm.Comm;
import org.hypertable.AsyncComm.Serialization;
import org.hypertable.AsyncComm.Event;
import org.hypertable.Common.Error;

public class RequestHandlerLength extends ApplicationHandler {

    static final Logger log = Logger.getLogger(
        "org.hypertable.DfsBroker.hadoop");

    public RequestHandlerLength(Comm comm, HadoopBroker broker, Event event) {
        super(event);
        mComm = comm;
        mBroker = broker;
    }

    public void run() {
        String  fileName;
        ResponseCallbackLength cb = new ResponseCallbackLength(mComm, mEvent);

        try {
            if ((fileName = Serialization.DecodeString(mEvent.payload)) == null)
                throw new ProtocolException(
                    "Filename not properly encoded in request packet");
            boolean accurate = mEvent.payload.get() == '\000' ? false : true;

            mBroker.Length(cb, fileName, accurate);
        }
        catch (ProtocolException e) {
            int error = cb.error(Error.PROTOCOL_ERROR, e.getMessage());
            log.severe("Protocol error (LENGTH) - " + e.getMessage());
            if (error != Error.OK)
                log.severe("Problem sending (LENGTH) error back to client - "
                           + Error.GetText(error));
        }
    }

    private Comm       mComm;
    private HadoopBroker mBroker;
}

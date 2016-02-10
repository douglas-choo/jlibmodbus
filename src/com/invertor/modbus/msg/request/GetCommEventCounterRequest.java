package com.invertor.modbus.msg.request;

import com.invertor.modbus.data.DataHolder;
import com.invertor.modbus.exception.ModbusNumberException;
import com.invertor.modbus.msg.base.ModbusRequest;
import com.invertor.modbus.msg.base.ModbusResponse;
import com.invertor.modbus.msg.response.GetCommEventCounterResponse;
import com.invertor.modbus.net.stream.base.ModbusInputStream;
import com.invertor.modbus.net.stream.base.ModbusOutputStream;
import com.invertor.modbus.utils.ModbusFunctionCode;

import java.io.IOException;

/**
 * Copyright (c) 2015-2016 JSC Invertor
 * [http://www.sbp-invertor.ru]
 * <p/>
 * This file is part of JLibModbus.
 * <p/>
 * JLibModbus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */
final public class GetCommEventCounterRequest extends ModbusRequest {

    public GetCommEventCounterRequest(int serverAddress) throws ModbusNumberException {
        super(serverAddress);
    }

    @Override
    public void writeRequest(ModbusOutputStream fifo) throws IOException {
        //no op
    }

    @Override
    public int requestSize() {
        return 0;
    }

    @Override
    public ModbusResponse getResponse(DataHolder dataHolder) throws ModbusNumberException {
        GetCommEventCounterResponse response = new GetCommEventCounterResponse(getServerAddress());
        response.setEventCount(dataHolder.getCommStatus().getEventCount());
        response.setStatus(dataHolder.getCommStatus().getStatus());
        return response;
    }

    @Override
    public void readPDU(ModbusInputStream fifo) throws ModbusNumberException, IOException {
        //no op
    }

    @Override
    public ModbusFunctionCode getFunction() {
        return ModbusFunctionCode.GET_COMM_EVENT_COUNTER;
    }
}

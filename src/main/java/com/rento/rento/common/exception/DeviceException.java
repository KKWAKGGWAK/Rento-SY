package com.rento.rento.common.exception;

import com.rento.rento.domain.device.enums.DeviceResultCode;
import lombok.Getter;

@Getter
public class DeviceException extends RuntimeException{

    private final String resultCode;

    private final String resultMessage;

    public DeviceException(DeviceResultCode deviceResultCode) {
        this.resultCode = deviceResultCode.getCode();
        this.resultMessage = deviceResultCode.getMessage();
    }

    public DeviceExceptionResponse toResponse() {

        return new DeviceExceptionResponse(resultCode, resultMessage);
    }

}

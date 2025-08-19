package com.rento.rento.domain.device.controller;

import com.rento.rento.domain.device.dto.request.DeviceRegisterRequest;
import com.rento.rento.domain.device.dto.request.DeviceSettingRequest;
import com.rento.rento.domain.device.dto.request.DeviceTokenRequest;
import com.rento.rento.domain.device.dto.resonse.DeviceRegisterResponse;
import com.rento.rento.domain.device.dto.resonse.DeviceSettingResponse;
import com.rento.rento.domain.device.dto.resonse.DeviceTokenResponse;
import org.springframework.http.ResponseEntity;

public interface DeviceController {

    ResponseEntity<DeviceRegisterResponse> registerDevice(DeviceRegisterRequest request);

    ResponseEntity<DeviceTokenResponse> issueToken(DeviceTokenRequest deviceTokenRequest);

    ResponseEntity<DeviceSettingResponse> getSetInfo(DeviceSettingRequest deviceSettingRequest);

}

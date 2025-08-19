package com.rento.rento.domain.event.controller;

import com.rento.rento.domain.device.entity.DeviceToken;
import com.rento.rento.domain.event.dto.request.onoff.OnEventRequest;
import com.rento.rento.domain.event.dto.response.EventResponse;
import org.springframework.http.ResponseEntity;

public interface OnOffController {

    ResponseEntity<EventResponse> onEvent(DeviceToken deviceToken, OnEventRequest request);
}

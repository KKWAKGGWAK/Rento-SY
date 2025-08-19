package com.rento.rento.domain.event.controller;

import com.rento.rento.domain.device.entity.DeviceToken;
import com.rento.rento.domain.event.dto.request.geofence.GeofenceEventRequest;
import com.rento.rento.domain.event.dto.response.EventResponse;
import org.springframework.http.ResponseEntity;

public interface GeofenceEventController {

    ResponseEntity<EventResponse> receiveGeofenceEvent(DeviceToken deviceToken, GeofenceEventRequest request);
}

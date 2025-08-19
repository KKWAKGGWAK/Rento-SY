package com.rento.rento.domain.event.controller;

import com.rento.rento.domain.device.entity.DeviceToken;
import com.rento.rento.domain.device.enums.DeviceResultCode;
import com.rento.rento.domain.event.dto.request.cycleinfo.CycleEventRequest;
import com.rento.rento.domain.event.dto.response.EventDataResponse;
import com.rento.rento.domain.event.dto.response.EventResponse;
import com.rento.rento.domain.event.entity.CycleEvent;
import com.rento.rento.domain.event.entity.CycleInfo;
import com.rento.rento.domain.event.service.CycleInfoService;
import com.rento.rento.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events/cycle-info")
public class CycleInfoControllerImpl implements CycleInfoController{

    private final CycleInfoService cycleInfoService;

    private final EventService eventService;


    @PostMapping
    public ResponseEntity<EventResponse> save(
        @AuthenticationPrincipal DeviceToken deviceToken,
        @RequestBody @Validated CycleEventRequest request
    ) {

        CycleEvent cycleEvent = request.toEntity(deviceToken.getDeviceId());

        List<CycleInfo> cycleInfoList = request.toCycleInfoEntities(deviceToken);
        cycleInfoService.saveCycleInfo(cycleInfoList);

        CycleEvent saveCycleEvent = eventService.saveCycleEvent(cycleEvent);

        return ResponseEntity.ok(EventResponse.fromEntity(DeviceResultCode.SUCCESS, saveCycleEvent));
    }

    @Override
    @GetMapping("/get-list")
    public ResponseEntity<List<EventDataResponse>> getList() {

        List<EventDataResponse> eventDataResponseList = eventService.getList()
                .stream().map(EventDataResponse::fromEntity).toList();

        return ResponseEntity.ok(eventDataResponseList);
    }
}

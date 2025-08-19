package com.rento.rento.domain.event.service;

import com.rento.rento.domain.device.entity.DeviceToken;
import com.rento.rento.domain.event.entity.CycleEvent;
import com.rento.rento.domain.event.entity.Event;
import com.rento.rento.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
  
    @Transactional
    public <T extends Event> T ignitionOnEvent(T event, DeviceToken deviceToken) {
        event.validateMdnMatch(deviceToken.getMdn());
      
        return eventRepository.save(event);
    }

    @Transactional
    public CycleEvent saveCycleEvent(CycleEvent cycleEvent) {

        return eventRepository.save(cycleEvent);
    }

    public List<Event> getList() {

        return eventRepository.findAll();
    }
}

package com.rento.rento.domain.event.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Entity
@SuperBuilder
@DiscriminatorValue("CYCLE_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CycleEvent extends Event{

    private LocalDateTime oTime;

    private Integer cycleCount;

}

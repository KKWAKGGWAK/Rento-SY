package com.rento.rento.domain.geofence.dto.request;

import com.rento.rento.domain.geofence.entity.Geofence;
import com.rento.rento.domain.geofence.enums.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GeofenceRegisterRequest(
        @NotBlank
        String companyCode,

        @NotBlank
        String name,

        @NotNull
        long latitude,

        @NotBlank
        long longitude,

        @NotNull
        int radius,
        String description
) {
    public static Geofence toEntity(GeofenceRegisterRequest request) {
        return Geofence.builder()
                .companyCode(request.companyCode)
                .name(request.name)
                .latitude(request.latitude)
                .longitude(request.longitude)
                .radius(request.radius)
                .eventType(EventType.OFF)
                .description(request.description)
                .isActive(false)
                .build();
    }
}

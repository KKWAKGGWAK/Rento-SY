package com.rento.rento.domain.drive.dto;

import com.rento.rento.domain.drive.entity.Drive;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DriveResponse(
        Long id,
        
        String memberName,

        String vehicleNumber,

        LocalDateTime startDate,

        LocalDateTime endDate,

        String startLocation,

        String endLocation,

        boolean isStart
) {
    public static DriveResponse fromEntity(Drive drive){
        return DriveResponse.builder()
                .id(drive.getId())
                .memberName(drive.getMember().getName())
                .vehicleNumber(drive.getVehicle().getInfo().vehicleNumber())
                .startDate(drive.getStartDate())
                .endDate(drive.getEndDate())
                .startLocation(drive.getStartLocation())
                .endLocation(drive.getEndLocation())
                .build();
    }
}

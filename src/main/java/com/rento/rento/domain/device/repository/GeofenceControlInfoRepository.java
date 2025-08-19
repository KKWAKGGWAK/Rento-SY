package com.rento.rento.domain.device.repository;

import com.rento.rento.domain.device.entity.GeofenceControlInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeofenceControlInfoRepository extends JpaRepository<GeofenceControlInfo, Long> {
    List<GeofenceControlInfo> findAllByMdn(Long mdn);
}

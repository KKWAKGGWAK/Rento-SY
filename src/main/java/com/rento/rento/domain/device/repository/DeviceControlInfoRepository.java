package com.rento.rento.domain.device.repository;

import com.rento.rento.domain.device.entity.DeviceControlInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceControlInfoRepository extends JpaRepository<DeviceControlInfo, Long> {
    List<DeviceControlInfo> findAllByMdn(Long mdn);
}

package com.rento.rento.domain.event.repository;

import com.rento.rento.domain.event.entity.CycleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleInfoRepository extends JpaRepository<CycleInfo, Long>, CycleInfoJdbcRepository {

}

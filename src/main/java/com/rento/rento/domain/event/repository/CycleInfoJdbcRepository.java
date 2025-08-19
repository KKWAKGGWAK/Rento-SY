package com.rento.rento.domain.event.repository;

import com.rento.rento.domain.event.entity.CycleInfo;

import java.util.List;

public interface CycleInfoJdbcRepository {

    void bulkInsert(List<CycleInfo> cycleInfo);
}

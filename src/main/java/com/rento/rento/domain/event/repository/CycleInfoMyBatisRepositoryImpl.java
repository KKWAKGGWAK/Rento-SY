package com.rento.rento.domain.event.repository;

import com.rento.rento.domain.event.entity.CycleInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CycleInfoMyBatisRepositoryImpl implements CycleInfoMyBatisRepository {

    private final CycleInfoMapper cycleInfoMapper;

    @Override
    public void bulkInsert(List<CycleInfo> cycleInfo) {
        cycleInfoMapper.bulkInsert(cycleInfo);
    }
}

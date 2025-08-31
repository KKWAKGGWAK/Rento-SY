package com.rento.rento.domain.event.service;

import com.rento.rento.domain.event.entity.CycleInfo;
import com.rento.rento.domain.event.repository.CycleInfoMyBatisRepository;
import com.rento.rento.domain.event.repository.CycleInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CycleInfoService {

    //private final CycleInfoRepository cycleInfoRepository;
    private final CycleInfoMyBatisRepository cycleInfoRepository;

    @Transactional
    public void saveCycleInfo(List<CycleInfo> cycleInfo) {

        long start = System.currentTimeMillis();

        cycleInfoRepository.bulkInsert(cycleInfo);

        long end = System.currentTimeMillis();

        log.info("DB 저장 소요 시간: {} ms", end - start);
    }
}

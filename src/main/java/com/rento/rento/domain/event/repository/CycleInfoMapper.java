package com.rento.rento.domain.event.repository;

import com.rento.rento.domain.event.entity.CycleInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CycleInfoMapper {

    @Insert("<script>"
            + "INSERT INTO cycle_info "
            + "(mdn, sec, gps_condition, latitude, longitude, angle, speed, sum, battery) "
            + "VALUES "
            + "<foreach collection='list' item='item' separator=','>"
            + "(#{item.mdn}, #{item.sec}, #{item.gpsCondition}, #{item.latitude}, #{item.longitude}, #{item.angle}, #{item.speed}, #{item.sum}, #{item.battery})"
            + "</foreach>"
            + "</script>")
    void bulkInsert(List<CycleInfo> cycleInfos);
}

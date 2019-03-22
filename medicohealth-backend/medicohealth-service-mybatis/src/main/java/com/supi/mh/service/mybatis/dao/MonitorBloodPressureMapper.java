package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.LatestBloodPressure;
import com.supi.mh.entity.pojo.MonitorBloodPressure;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorBloodPressureMapper {
    int deleteByPrimaryKey(Integer bloodPressureId);

    int insert(MonitorBloodPressure record);

    int insertSelective(MonitorBloodPressure record);

    MonitorBloodPressure selectByPrimaryKey(Integer bloodPressureId);

    int updateByPrimaryKeySelective(MonitorBloodPressure record);

    int updateByPrimaryKey(MonitorBloodPressure record);

    LatestBloodPressure selectLatest(Integer elder_id);
}
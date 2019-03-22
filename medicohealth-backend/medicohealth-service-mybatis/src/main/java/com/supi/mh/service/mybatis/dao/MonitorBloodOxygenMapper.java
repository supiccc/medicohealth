package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorBloodOxygen;

public interface MonitorBloodOxygenMapper {
    int deleteByPrimaryKey(Integer bloodOxygenId);

    int insert(MonitorBloodOxygen record);

    int insertSelective(MonitorBloodOxygen record);

    MonitorBloodOxygen selectByPrimaryKey(Integer bloodOxygenId);

    int updateByPrimaryKeySelective(MonitorBloodOxygen record);

    int updateByPrimaryKey(MonitorBloodOxygen record);

    MonitorBloodOxygen selectLatest(int elder_id);
}
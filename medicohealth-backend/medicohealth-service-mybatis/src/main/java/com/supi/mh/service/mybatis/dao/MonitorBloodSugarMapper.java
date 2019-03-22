package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorBloodSugar;

public interface MonitorBloodSugarMapper {
    int deleteByPrimaryKey(Integer bloodSugarId);

    int insert(MonitorBloodSugar record);

    int insertSelective(MonitorBloodSugar record);

    MonitorBloodSugar selectByPrimaryKey(Integer bloodSugarId);

    int updateByPrimaryKeySelective(MonitorBloodSugar record);

    int updateByPrimaryKey(MonitorBloodSugar record);

    MonitorBloodSugar selectLatest(int elder_id);
}
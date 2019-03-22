package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorFat;

public interface MonitorFatMapper {
    int deleteByPrimaryKey(Integer fatId);

    int insert(MonitorFat record);

    int insertSelective(MonitorFat record);

    MonitorFat selectByPrimaryKey(Integer fatId);

    int updateByPrimaryKeySelective(MonitorFat record);

    int updateByPrimaryKey(MonitorFat record);

    MonitorFat selectLatest(int elder_id);
}
package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorHeightWeight;

public interface MonitorHeightWeightMapper {
    int deleteByPrimaryKey(Integer heightWeightId);

    int insert(MonitorHeightWeight record);

    int insertSelective(MonitorHeightWeight record);

    MonitorHeightWeight selectByPrimaryKey(Integer heightWeightId);

    int updateByPrimaryKeySelective(MonitorHeightWeight record);

    int updateByPrimaryKey(MonitorHeightWeight record);

    MonitorHeightWeight selectLatest(int elder_id);
}
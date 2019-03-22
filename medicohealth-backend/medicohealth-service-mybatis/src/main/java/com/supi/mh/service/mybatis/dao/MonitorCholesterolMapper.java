package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorCholesterol;

public interface MonitorCholesterolMapper {
    int deleteByPrimaryKey(Integer cholesterolId);

    int insert(MonitorCholesterol record);

    int insertSelective(MonitorCholesterol record);

    MonitorCholesterol selectByPrimaryKey(Integer cholesterolId);

    int updateByPrimaryKeySelective(MonitorCholesterol record);

    int updateByPrimaryKey(MonitorCholesterol record);

    MonitorCholesterol selectLatest(int elder_id);
}
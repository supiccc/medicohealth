package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.MonitorUricAcid;

public interface MonitorUricAcidMapper {
    int deleteByPrimaryKey(Integer uricAcidId);

    int insert(MonitorUricAcid record);

    int insertSelective(MonitorUricAcid record);

    MonitorUricAcid selectByPrimaryKey(Integer uricAcidId);

    int updateByPrimaryKeySelective(MonitorUricAcid record);

    int updateByPrimaryKey(MonitorUricAcid record);

    MonitorUricAcid selectLatest(int elder_id);
}
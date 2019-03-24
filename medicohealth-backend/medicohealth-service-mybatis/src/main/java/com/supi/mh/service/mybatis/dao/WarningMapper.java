package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.Warning;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WarningMapper {
    int deleteByPrimaryKey(Integer idwarning);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(Integer idwarning);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKeyWithBLOBs(Warning record);

    int updateByPrimaryKey(Warning record);

    ArrayList<Warning> selectAll();
}
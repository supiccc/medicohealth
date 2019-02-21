package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.OrganizationHospital;

import java.util.ArrayList;

public interface OrganizationHospitalMapper {
    int deleteByPrimaryKey(Integer hospitalId);

    int insert(OrganizationHospital record);

    int insertSelective(OrganizationHospital record);

    OrganizationHospital selectByPrimaryKey(Integer hospitalId);

    int updateByPrimaryKeySelective(OrganizationHospital record);

    int updateByPrimaryKey(OrganizationHospital record);

    ArrayList<OrganizationHospital> selectAll();
}
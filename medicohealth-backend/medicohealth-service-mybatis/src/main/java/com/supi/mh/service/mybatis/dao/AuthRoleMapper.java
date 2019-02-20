package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.AuthRole;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);
}
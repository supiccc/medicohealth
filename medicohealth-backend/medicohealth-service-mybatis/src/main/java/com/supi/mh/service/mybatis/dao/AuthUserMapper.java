package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.AuthUser;

public interface AuthUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    AuthUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);

    AuthUser findByUserName(String username);
}
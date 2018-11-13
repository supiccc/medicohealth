package com.supi.mh.service.mybatis.dao;

import com.supi.mh.service.mybatis.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer iduser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer iduser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
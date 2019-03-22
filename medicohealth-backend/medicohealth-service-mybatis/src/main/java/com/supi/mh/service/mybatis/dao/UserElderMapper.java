package com.supi.mh.service.mybatis.dao;

import com.supi.mh.entity.pojo.UserElder;

public interface UserElderMapper {
    int deleteByPrimaryKey(Integer elderId);

    int insert(UserElder record);

    int insertSelective(UserElder record);

    UserElder selectByPrimaryKey(Integer elderId);

    int updateByPrimaryKeySelective(UserElder record);

    int updateByPrimaryKey(UserElder record);

    int selectByUserId(Integer userId);
}
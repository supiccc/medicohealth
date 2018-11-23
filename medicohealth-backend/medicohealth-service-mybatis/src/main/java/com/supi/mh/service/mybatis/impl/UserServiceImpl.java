package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.User;
import com.supi.mh.service.mybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2018-11-14 15:32
 */

@Service(version = "${dubbo.application.version}")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByName(int id) {
        return userMapper.selectByPrimaryKey(1);
    }
}

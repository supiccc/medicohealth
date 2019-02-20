package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.AuthRole;
import com.supi.mh.entity.pojo.AuthUser;
import com.supi.mh.entity.pojo.User;
import com.supi.mh.service.mybatis.dao.AuthRoleMapper;
import com.supi.mh.service.mybatis.dao.AuthUserMapper;
import com.supi.mh.service.mybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2018-11-14 15:32
 */

@Service(version = "${dubbo.application.version}")
public class UserServiceImpl implements UserService {

    @Autowired
    AuthUserMapper userMapper;

    @Autowired
    AuthRoleMapper roleMapper;

    @Override
    public AuthUser findByName(int id) {
        return userMapper.selectByPrimaryKey(1);
    }


    @Override
    public AuthUser findByUsername(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public String findRoleNameById(Integer id) {
        return roleMapper.selectByPrimaryKey(id).getRoleName();
    }
}

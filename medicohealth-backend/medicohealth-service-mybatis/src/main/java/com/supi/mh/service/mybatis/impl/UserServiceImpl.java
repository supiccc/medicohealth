package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.AuthRole;
import com.supi.mh.entity.pojo.AuthUser;
import com.supi.mh.entity.pojo.MonitorBloodPressure;
import com.supi.mh.entity.pojo.User;
import com.supi.mh.service.mybatis.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2018-11-14 15:32
 */

@Service(version = "${dubbo.application.version}")
public class UserServiceImpl implements UserService {

    private AuthUserMapper userMapper;

    private AuthRoleMapper roleMapper;

    private UserElderMapper userElderMapper;


    public UserElderMapper getUserElderMapper() {
        return userElderMapper;
    }

    @Autowired
    public void setUserElderMapper(UserElderMapper userElderMapper) {
        this.userElderMapper = userElderMapper;
    }

    public AuthUserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(AuthUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public AuthRoleMapper getRoleMapper() {
        return roleMapper;
    }

    @Autowired
    public void setRoleMapper(AuthRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

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

    @Override
    public Integer findElderIdById(Integer id) {
        return userElderMapper.selectByUserId(id);
    }
}

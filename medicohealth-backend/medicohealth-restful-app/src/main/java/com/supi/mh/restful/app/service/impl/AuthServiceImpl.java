package com.supi.mh.restful.app.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.AuthProfile;
import com.supi.mh.entity.pojo.AuthUser;
import com.supi.mh.restful.app.service.AuthService;
import com.supi.mh.restful.app.service.RedisService;
import exceptions.PasswordErrorException;
import exceptions.UserNotFoundException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.RandomString;

/**
 * Created by supiccc on 2019-02-19 13:46
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean isLogin(String username, String token) {
        try {

            String oldValue = redisService.get(token).toString();
            return oldValue.equals("auth_" + username);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public AuthProfile login(String username, String password, String token) throws UserNotFoundException, PasswordErrorException {
        if(token == null) {
            logout(token);
        }
        AuthUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        // 密码加密
        String encode_password = new Md5Hash(password, user.getAuthSalt(), 2).toString();
        if (!encode_password.equals(user.getAuthPassword())) {
            throw new PasswordErrorException();
        }
        // 生成32 位token
        String new_token = new RandomString().generateString(32);
        // 生成保存用户登录信息的profile
        AuthProfile authProfile = new AuthProfile();
        authProfile.setUsername(username);
        authProfile.setToken(new_token);
        authProfile.setRole(userService.findRoleNameById(user.getAuthRoleRoleId()));
        // 保存用户登录信息到redis数据库, 过期时间设置为24hour
        redisService.set(new_token, "auth_"+user.getAuthUsername(), 1440);
        return authProfile;

    }

    @Override
    public boolean logout(String token) {
        System.err.println(token);
        return redisService.del(token);
    }
}

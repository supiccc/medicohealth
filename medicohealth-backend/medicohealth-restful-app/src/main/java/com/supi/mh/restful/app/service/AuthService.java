package com.supi.mh.restful.app.service;

import com.supi.mh.entity.pojo.AuthProfile;
import exceptions.PasswordErrorException;
import exceptions.UserNotFoundException;

/**
 * Created by supiccc on 2019-02-19 13:46
 */
public interface AuthService {


    /**
     * 登录验证
     * @param username 用户名
     * @param token 验证
     * @return 返回true or false
     */
    boolean isLogin(String username, String token);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户，失败返回null
     */
    AuthProfile login(String username, String password, String token) throws UserNotFoundException, PasswordErrorException;

    /**
     * 注销
     * @param token token
     * @return 成功返回true
     */
    boolean logout(String token);
}

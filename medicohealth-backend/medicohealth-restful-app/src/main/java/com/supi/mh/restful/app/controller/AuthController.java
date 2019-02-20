package com.supi.mh.restful.app.controller;

import com.supi.mh.entity.pojo.AuthProfile;
import com.supi.mh.restful.app.service.AuthService;
import exceptions.PasswordErrorException;
import exceptions.UserNotFoundException;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by supiccc on 2019-02-19 13:45
 */
@RestController
@RequestMapping("/auth/v2")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return code：0 成功 1 密码错误 2 用户名错误
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseJson login(String username, String password, HttpServletRequest request) {
        try {
            String token = request.getHeader("token") == null ? "" : request.getHeader("token");
            AuthProfile authProfile = authService.login(username, password, token);
            return new ResponseJson(0, null, authProfile);
        } catch (UserNotFoundException e) {
            return new ResponseJson(2, null, null);
        } catch (PasswordErrorException e) {
            return new ResponseJson(1, null, null);
        }
    }

    /**
     * 注销
     * @param username 用户名
     * @return code: 0 成功 1 未知错误
     */
    @RequestMapping(value = "/logout")
    public ResponseJson logout(String username) {
        if (authService.logout(username)) {
            return new ResponseJson(0, null, null);
        } else {
            return new ResponseJson(1, null, null);
        }
    }

    @RequestMapping(value = "/session/get")
    public ResponseJson getSession(HttpServletRequest request) {
        try {
            String res = request.getHeader("token");
            return new ResponseJson(0, null, res);
        } catch (NullPointerException e) {
            return new ResponseJson(1, null, null);
        }

    }
}

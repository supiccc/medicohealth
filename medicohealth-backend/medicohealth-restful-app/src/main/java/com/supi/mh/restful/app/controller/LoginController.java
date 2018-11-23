package com.supi.mh.restful.app.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.User;
import com.supi.mh.restful.app.handler.ShiroSvc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-11-13 17:49
 */
@RestController
@RequestMapping("/login/v1")
public class LoginController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Autowired
    private ShiroSvc shiroSvc;

    @RequestMapping("testsql")
    public User find() {
        return userService.findByName(1);
    }

    @RequestMapping("/hello")
    public String hello() {
        return shiroSvc.hello();
    }

    @RequestMapping("/nologin")
    public String nologin() {
        return "未登录";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(String username, String password) {
        try {
            shiroSvc.login(username, password);

        } catch (UnknownAccountException e) {
            return "没有该用户";
        } catch (IncorrectCredentialsException e) {
            return "密码错误";
        }
        return "登录成功";
    }
}

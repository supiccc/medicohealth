package com.supi.mh.restful.app.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by supiccc on 2018-11-15 15:44
 */
@Service
public class ShiroSvc {
//    public String hello() {
//        return "hello world";
//    }
//
//    public void login(String username, String password) throws AuthenticationException {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken utoken = new UsernamePasswordToken(username, password);
//        subject.login(utoken);
//    }
}

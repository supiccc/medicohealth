package com.supi.mh.email.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.EmailContextService;
import com.supi.mh.email.service.api.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by supiccc on 2018-10-30 15:37
 */
@Service(version = "${dubbo.application.version}")
public class EmailContext implements EmailContextService {

    private EmailService emailService = null;

    @Autowired
    @Qualifier("2Admin")
    private EmailService sendEmail2Admin;

//    @Autowired
//    @Qualifier("2UserChangeEmail")
//    private EmailService sendEmail2UserChangeEmail;
//
//    @Autowired
//    @Qualifier("2UserChangePwd")
//    private EmailService sendEmail2UserChangePwd;
//
//    @Autowired
//    @Qualifier("2UserRegister")
//    private EmailService sendEmail2UserRegister;

    // 策略模式
    @Override
    public void getIntance(String type) {
        switch (type) {
            case "toAdmin":
                emailService = sendEmail2Admin;
                break;
//            case "toChangePwd":
////                emailService = new SendEmail2UserChangePwd();  mmp，spring 不要用new，会导致无法注入
//                emailService = sendEmail2UserChangePwd;
//                break;
//            case "toChangeEmail":
////                emailService = new SendEmail2UserChangeEmail();
//                emailService = sendEmail2UserChangeEmail;
//            case "toRegister":
////                emailService = new SendEmail2UserRegister();
//                emailService = sendEmail2UserRegister;
//                break;
        }
    }

    @Override
    public int sendto(String email, String content) {
        return emailService.sendto(email, content);
    }
}

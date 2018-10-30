package com.supi.mh.email.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.EmailContextService;
import com.supi.mh.email.service.api.EmailService;

/**
 * Created by supiccc on 2018-10-30 15:37
 */
@Service(version = "${dubbo.application.version}")
public class EmailContext implements EmailContextService {

    private EmailService emailService = null;

    // 策略模式
    @Override
    public void getIntance(String type) {
        switch (type) {
            case "toAdmin":
                emailService = new SendEmail2Admin();
                break;
            case "toChangePwd":
                emailService = new SendEmail2UserChangePwd();
                break;
            case "toChangeEmail":
                emailService = new SendEmail2UserChangeEmail();
            case "toRegister":
                emailService = new SendEmail2UserRegister();
                break;
        }
    }

    @Override
    public int sendto(String email, int randomCode, String subject, String mode) {
        return emailService.sendto(email, randomCode, subject, mode);
    }
}

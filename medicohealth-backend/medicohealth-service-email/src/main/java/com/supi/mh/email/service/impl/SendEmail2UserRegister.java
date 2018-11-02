package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;
import org.springframework.stereotype.Component;

/**
 * Created by supiccc on 2018-10-30 15:11
 * Description 发送注册验证邮件
 */
@Component("2UserRegister")
public class SendEmail2UserRegister implements EmailService {


    /**
     *
     * @param email
     * @param content
     * @return
     */
    @Override
    public int sendto(String email, String content) {
        String mode = "";
        return 0;
    }
}

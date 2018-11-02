package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;
import com.supi.mh.email.service.core.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by supiccc on 2018-10-30 15:10
 * Description 发送邮件给管理员
 */
@Component("2Admin")
public class SendEmail2Admin implements EmailService {

    @Value("${mail.admin.addr}")
    private String to;

    @Autowired
    private MailService mailService;
    /**
     *
     * @param email
     * @param content
     * @return
     */
    @Override
    public int sendto(String email, String content) {
        String subject = new Date().toString() + "Medico Health 意见反馈";
        System.out.println(to);
        mailService.sendSimpleMail(to, subject, content);
        return 0;
    }
}

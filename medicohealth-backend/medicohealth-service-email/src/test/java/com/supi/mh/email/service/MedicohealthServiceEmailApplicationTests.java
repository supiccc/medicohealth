package com.supi.mh.email.service;

import com.supi.mh.email.service.core.MailService;
import com.supi.mh.email.service.impl.SendEmail2Admin;
import com.supi.mh.email.service.impl.SendEmail2UserChangeEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicohealthServiceEmailApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private SendEmail2UserChangeEmail sendEmail2UserChangeEmail;

    /**
     * 测试发送验证邮件给用户
     */
    @Test
    public void testSendEmail2UserChangeEmail() {
        sendEmail2UserChangeEmail.sendto("supiccc@gmail.com", "");
    }

    /**
     * 测试邮件发送核心模块
     */
    @Test
    public void contextLoads() {
        mailService.sendSimpleMail("supiccc@gmail.com", (new Date()).toString() + "邮件模块测试", "成功，要撒花！");
    }

    /**
     * 测试日期函数
     */
    @Test
    public void showToday() {
        System.out.println(new Date().toString());
    }

}

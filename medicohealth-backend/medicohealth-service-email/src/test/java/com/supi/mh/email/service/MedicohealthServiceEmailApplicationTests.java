package com.supi.mh.email.service;

import com.supi.mh.email.service.core.MailService;
import com.supi.mh.email.service.impl.SendEmail2Admin;
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
    private SendEmail2Admin sendEmail2Admin;

    @Test
    public void testSendEmail2Admin() {
        sendEmail2Admin.sendto("supiccc@gmail.com", "我发现发邮件模块有个小bug");
    }

    @Test
    public void contextLoads() {
        mailService.sendSimpleMail("supiccc@gmail.com", (new Date()).toString() + "邮件模块测试", "成功，要撒花！");
    }

    @Test
    public void showToday() {
        System.out.println(new Date().toString());
    }

}

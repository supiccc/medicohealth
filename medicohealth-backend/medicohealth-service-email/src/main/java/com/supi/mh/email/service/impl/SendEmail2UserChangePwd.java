package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;
import com.supi.mh.email.service.core.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.RandomCode;

/**
 * Created by supiccc on 2018-10-30 15:32
 * Description 发送修改密码验证邮件
 */
@Component("2UserChangePwd")
public class SendEmail2UserChangePwd implements EmailService {

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
        String subject = "【Medico Health】修改密码验证";
        String mode = "您正在使用修改密码功能";
        String randomCode = RandomCode.getRandomCodeStr6();
        String contents = "尊敬的用户：" + "\n  您好!" + "\n  " + mode + "。\n" + "\n  您的邮箱验证码为【" + randomCode + "】，请于10分钟内输入，任何人都不会向您索取，请勿泄露。"
                + "\n  注：如果不是您发出的请求，说明您的邮箱可能被人冒用或者存在风险，请留意。" + "\n\n\n此致，Medico Health项目组";        mailService.sendSimpleMail(email, subject, contents);
        return 0;
    }
}

package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;
import org.springframework.stereotype.Component;

/**
 * Created by supiccc on 2018-10-30 15:32
 * Description 发送修改密码验证邮件
 */
@Component("2UserChangePwd")
public class SendEmail2UserChangePwd implements EmailService {

    /**
     *
     * @param email
     * @param content
     * @return
     */
    @Override
    public int sendto(String email, String content) {
        return 0;
    }
}

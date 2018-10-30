package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;

/**
 * Created by supiccc on 2018-10-30 15:11
 * Description 发送注册验证邮件
 */
public class SendEmail2UserRegister implements EmailService {

    /**
     *
     * @param email 邮箱地址
     * @param randomCode 验证码
     * @param subject 邮件主题
     * @param mode 邮件类型
     * @return 错误码
     */
    @Override
    public int sendto(String email, int randomCode, String subject, String mode) {
        return 0;
    }
}

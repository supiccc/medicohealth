package com.supi.mh.email.service.impl;

import com.supi.mh.email.service.api.EmailService;

/**
 * Created by supiccc on 2018-10-30 15:10
 * Description 发送邮件给管理员
 */
public class SendEmail2Admin implements EmailService {
    /**
     *
     * @param email 邮箱地址
     * @param randomCode 验证码(弃用)
     * @param subject 邮件主题
     * @param content 邮件内容
     * @return
     */
    @Override
    public int sendto(String email, int randomCode, String subject, String content) {
        System.out.println("test");
        return 0;
    }
}

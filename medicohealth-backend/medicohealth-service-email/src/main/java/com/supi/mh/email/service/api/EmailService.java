package com.supi.mh.email.service.api;

/**
 * Created by supiccc on 2018-10-30 02:07
 * Description 邮件接口
 */
public interface EmailService {


    /**
     *
     * @param email 邮箱地址
     * @param randomCode 验证码
     * @param subject 邮件主题
     * @param mode 邮件类型
     * @return 错误码
     */
    int sendto(String email, int randomCode, String subject, String mode);
}

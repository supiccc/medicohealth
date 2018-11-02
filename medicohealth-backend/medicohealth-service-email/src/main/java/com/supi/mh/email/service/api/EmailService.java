package com.supi.mh.email.service.api;

/**
 * Created by supiccc on 2018-10-30 02:07
 * Description 邮件接口
 */
public interface EmailService {

    /**
     *
     * @param email
     * @param content
     * @return
     */
    int sendto(String email, String content);
}

package com.supi.mh.api;

/**
 * Created by supiccc on 2018-10-30 15:54
 */
public interface EmailContextService {
    /**
     *
     * @param type
     */
    void getIntance(String type);

    /**
     *
     * @param email 邮件地址
     * @param content 邮件内容
     * @return 状态码
     */
    int sendto(String email, String content);
}

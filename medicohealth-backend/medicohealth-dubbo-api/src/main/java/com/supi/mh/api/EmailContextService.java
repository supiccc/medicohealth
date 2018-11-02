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
     * @param email
     * @param content
     * @return
     */
    int sendto(String email, String content);
}

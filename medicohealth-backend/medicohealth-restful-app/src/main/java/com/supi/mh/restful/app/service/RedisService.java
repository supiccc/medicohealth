package com.supi.mh.restful.app.service;

/**
 * Created by supiccc on 2018-10-12 15:45
 */
public interface RedisService {
    /**
     * 插入<String, String> 到redis中
     * @param key 键
     * @param value 值
     * @param time 时间
     */
    void set(String key, String value, long time);

    /**
     * 获取redis中的数据
     * @param key 键
     * @return 键值对象
     */
    Object get(String key);

    /**
     * 删除redis中的数据
     * @param key
     * @return
     */
    boolean del(String key);
}

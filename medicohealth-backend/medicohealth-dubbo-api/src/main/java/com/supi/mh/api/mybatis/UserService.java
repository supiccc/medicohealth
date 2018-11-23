package com.supi.mh.api.mybatis;


import com.supi.mh.entity.pojo.User;

/**
 * Created by supiccc on 2018-11-14 15:22
 */
public interface UserService {
    User findByName(int id);
}

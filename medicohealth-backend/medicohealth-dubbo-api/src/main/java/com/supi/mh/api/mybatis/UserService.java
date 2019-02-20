package com.supi.mh.api.mybatis;


import com.supi.mh.entity.pojo.AuthRole;
import com.supi.mh.entity.pojo.AuthUser;

/**
 * Created by supiccc on 2018-11-14 15:22
 */
public interface UserService {
    AuthUser findByName(int id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    AuthUser findByUsername(String username);

    String findRoleNameById(Integer id);
}

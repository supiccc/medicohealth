package com.supi.mh.api.mybatis;


import com.supi.mh.entity.pojo.AuthRole;
import com.supi.mh.entity.pojo.AuthUser;

/**
 * Created by supiccc on 2018-11-14 15:22
 */
public interface UserService {

    /**
     * 根据用户ID查找用户
     * @param id 用户id
     * @return 用户对象
     */
    AuthUser findByName(int id);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 用户
     */
    AuthUser findByUsername(String username);

    /**
     * 根据用户id查找用户角色
     * @param id 用户id
     * @return 用户角色信息
     */
    String findRoleNameById(Integer id);

    /**
     *  根据用户id查询居民id
     * @param id 用户id
     * @return 居民id
     */
    Integer findElderIdById(Integer id);
}

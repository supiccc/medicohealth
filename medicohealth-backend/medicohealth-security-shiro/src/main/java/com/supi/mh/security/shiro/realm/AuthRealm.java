package com.supi.mh.security.shiro.realm;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.User;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by supiccc on 2018-11-15 11:13
 * Description 数据源
 */
public class AuthRealm extends AuthorizingRealm {

    private static final Logger log = Logger.getLogger(AuthRealm.class);

    @Reference(version = "1.0.0")
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录，认证
     * @param authenticationToken 认证信息
     * @return 认证结果
     * @throws AuthenticationException 包括：密码错误、用户不存在等异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken)authenticationToken;
        String username = utoken.getUsername();
        User user = userService.findByName(1);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}

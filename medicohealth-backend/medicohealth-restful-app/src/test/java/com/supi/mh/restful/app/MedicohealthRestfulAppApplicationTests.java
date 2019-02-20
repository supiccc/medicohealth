package com.supi.mh.restful.app;

import com.supi.mh.entity.pojo.AuthProfile;
import com.supi.mh.restful.app.service.AuthService;
import com.supi.mh.restful.app.service.RedisService;
import exceptions.PasswordErrorException;
import exceptions.UserNotFoundException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicohealthRestfulAppApplicationTests {

    @Autowired
    AuthService authService;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试认证模块
     * @throws UserNotFoundException
     * @throws PasswordErrorException
     */
    @Test
    public void testAuth() throws UserNotFoundException, PasswordErrorException {
        AuthProfile authProfile = authService.login("supiccc", "chen", "");
        Assert.assertEquals(authProfile.getUsername(), "supiccc");
        Assert.assertEquals(authProfile.getRole(), "admin");
        assert authService.isLogin("supiccc", authProfile.getToken());
        assert authService.logout(authProfile.getToken());
        assert !authService.isLogin("supiccc", authProfile.getToken());
    }


}

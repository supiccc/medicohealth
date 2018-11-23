package com.supi.mh.service.mybatis;

import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.service.mybatis.dao.UserMapper;
import com.supi.mh.service.mybatis.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicohealthServiceMybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSql() {
        System.out.println(userMapper.selectByPrimaryKey(1).getPassword());
    }

}

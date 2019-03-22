package com.supi.mh.service.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supi.mh.api.mybatis.HospitalService;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.MonitorBloodPressure;
import com.supi.mh.entity.pojo.OrganizationHospital;
import com.supi.mh.entity.pojo.UserElder;
import com.supi.mh.service.mybatis.dao.*;
import com.supi.mh.service.mybatis.impl.UserServiceImpl;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicohealthServiceMybatisApplicationTests {

    @Autowired
    private AuthUserMapper userMapper;

    @Autowired
    private OrganizationHospitalMapper organizationHospitalMapper;

    @Autowired
    private MonitorBloodPressureMapper monitorBloodPressureMapper;

    @Autowired
    private MonitorBloodOxygenMapper monitorBloodOxygenMapper;

    @Autowired
    private UserElderMapper userElderMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSql() {
        System.out.println(userMapper.selectByPrimaryKey(1).getAuthPassword());
        System.err.println(userMapper.findByUserName("supiccc").getAuthPhone());
        List<OrganizationHospital> lists = organizationHospitalMapper.selectAll();
        for (OrganizationHospital li : lists) {
            System.out.println(li.getHospitalName());
        }
    }

    /**
     * 测试获取最新的血压值
     */
    @Test
    public void getLatestBloodPressure() {
        System.err.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.err.println(sdf.format(monitorBloodPressureMapper.selectLatest(1).getBloodPressureCreateTime()));
    }


    @Test
    public void getLatestOxygen() {
        System.out.println(monitorBloodOxygenMapper.selectLatest(1).getBloodOxygenCreateTime());
    }

    /**
     * 获取居民id
     */
    @Test
    public void getElderId() {
        System.err.println(userElderMapper.selectByUserId(3));
    }


    /**
     * 插入血压值
     */
    @Test
    @Rollback
    public void insertBloodPressure() {
        MonitorBloodPressure m = new MonitorBloodPressure();
        m.setDiastolic((float) 74.3);
        m.setShrink((float) 123);
        m.setPulse((byte) 60);
        m.setElderId(1);
        monitorBloodPressureMapper.insertSelective(m);
    }
}

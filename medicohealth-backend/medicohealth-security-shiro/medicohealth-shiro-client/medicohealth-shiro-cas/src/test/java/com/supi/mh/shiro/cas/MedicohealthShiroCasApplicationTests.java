package com.supi.mh.shiro.cas;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicohealthShiroCasApplicationTests {
    private String staticSalt = ".";
    private String algorithmName = "MD5";
    private String encodedPassword = "chen";
    private String dynaSalt = "QxLUF1bgIAdeQX";

    @Test
    public void contextLoads() {

        String res2 = new Md5Hash(encodedPassword, dynaSalt, 2).toString();
        String res3 = new Md5Hash("chen").toString();
        System.err.println(res2);
        System.err.println(res3);
    }

}

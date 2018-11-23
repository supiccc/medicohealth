package com.supi.mh.email.restful;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.supi.mh.security.shiro","com.supi.mh.email.restful"})
@EnableDubboConfig
public class MedicohealthRestfulEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicohealthRestfulEmailApplication.class, args);
    }
}

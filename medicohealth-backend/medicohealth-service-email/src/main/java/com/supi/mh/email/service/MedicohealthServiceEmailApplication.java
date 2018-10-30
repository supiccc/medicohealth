package com.supi.mh.email.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubboConfig
public class MedicohealthServiceEmailApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MedicohealthServiceEmailApplication.class).web(false).run(args);
    }
}

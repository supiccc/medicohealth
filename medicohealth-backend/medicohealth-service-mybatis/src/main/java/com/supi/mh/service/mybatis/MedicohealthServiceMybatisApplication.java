package com.supi.mh.service.mybatis;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.supi.mh.service.mybatis.dao")
@EnableDubboConfig
public class MedicohealthServiceMybatisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MedicohealthServiceMybatisApplication.class, args);
        new SpringApplicationBuilder(MedicohealthServiceMybatisApplication.class).run(args);
    }
}

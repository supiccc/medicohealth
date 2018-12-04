package com.supi.mh.restful.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.supi.mh.restful.app", "com.supi.mh.shiro.cas"})
public class MedicohealthRestfulAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicohealthRestfulAppApplication.class, args);
    }
}

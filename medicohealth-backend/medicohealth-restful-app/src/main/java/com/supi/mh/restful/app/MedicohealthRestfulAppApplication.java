package com.supi.mh.restful.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication()
public class MedicohealthRestfulAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicohealthRestfulAppApplication.class, args);
    }
}

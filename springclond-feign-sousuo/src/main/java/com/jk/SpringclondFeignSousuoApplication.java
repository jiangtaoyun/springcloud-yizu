package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringclondFeignSousuoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringclondFeignSousuoApplication.class, args);
    }

}

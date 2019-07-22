package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringclondFeignBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringclondFeignBackstageApplication.class, args);
    }

}

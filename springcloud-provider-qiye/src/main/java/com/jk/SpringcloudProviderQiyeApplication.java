package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jk.dao")
@EnableTransactionManagement
public class SpringcloudProviderQiyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderQiyeApplication.class, args);
    }

}

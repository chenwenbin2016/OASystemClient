package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OASystemCilent 程序入口
 */
@SpringBootApplication(scanBasePackages = {"com.oaclient"})
@EnableAutoConfiguration
@MapperScan(value = "com.oaclient.mapper")
public class SpringBootOASystemClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootOASystemClientApplication.class,args);
    }
}

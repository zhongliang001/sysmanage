package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@EnableEurekaClient
@Configuration
@ComponentScan
@MapperScan("com.zl.sysadminservice.*.mapper")
public class SysAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysAdminServiceApplication.class, args);
    }

}

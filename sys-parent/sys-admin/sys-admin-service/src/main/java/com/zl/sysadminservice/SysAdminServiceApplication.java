package com.zl.sysadminservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
@MapperScan("com.zl.sysadminservice.sdict.mapper")
public class SysAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysAdminServiceApplication.class, args);
    }

}

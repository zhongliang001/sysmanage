package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.zl.uua.mapper")
//@EnableApolloConfig
public class UaaApplication
{
    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }
}

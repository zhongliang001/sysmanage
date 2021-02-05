package com.zl;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zl.uua.mapper")
@EnableApolloConfig
public class UaaApplication
{
    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }
}

package com.zl.sysgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@EnableEurekaClient
@Configuration
@ComponentScan
public class SysGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysGatewayApplication.class, args);
    }

}

package com.zl.sysgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SysGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysGatewayApplication.class, args);
    }

}

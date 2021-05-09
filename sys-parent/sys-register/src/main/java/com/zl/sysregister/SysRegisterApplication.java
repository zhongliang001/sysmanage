package com.zl.sysregister;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhongliang
 */

@SpringBootApplication
@EnableEurekaServer
@EnableApolloConfig
public class SysRegisterApplication {

    public static void main(String[] args) {

        SpringApplication.run(SysRegisterApplication.class, args);
    }

}

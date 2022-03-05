package com.zl;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongliang
 */
@EnableAutoConfiguration
@EnableEurekaClient
@Configuration
@ComponentScan
@EnableApolloConfig
@MapperScan({"com.zl.syssequence.*.mapper", "com.zl.syssequence.mapper"})
public class SysSequenceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SysSequenceApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

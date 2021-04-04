package com.zl.sysgateway.config;


import com.zl.base.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author zhongliang
 */
@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.basicAuthentication(applicationProperties.getSecurity().getUsername(), applicationProperties.getSecurity().getPassword()).build();
    }
}

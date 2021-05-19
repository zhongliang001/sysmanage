package com.zl.common.config;

import com.zl.common.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhongliang
 */
@Configuration
public class ZlWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private LogInterceptor logInterceptor;

//    @Autowired
//    private FeignConfiguration feignConfiguration;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
//        registry.addInterceptor(feignConfiguration);
    }
}

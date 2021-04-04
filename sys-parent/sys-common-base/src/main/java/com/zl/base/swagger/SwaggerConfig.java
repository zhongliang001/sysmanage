package com.zl.base.swagger;


import com.zl.base.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongliang
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String title;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public Docket createRestApi() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder rb = new RequestParameterBuilder();
        rb.name("real_source_ip").description("本机局域网IP").in(ParameterType.HEADER).name("Token").required(true);
        pars.add(rb.build());
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zl"))
                .paths(PathSelectors.any())
                .build().globalRequestParameters(pars);

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
//                .description(title)
//                .contact("程序猿DD")
                .version("2.0")
                .build();
    }

}

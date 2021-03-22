package com.zl.sysgateway.swagger.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.basicAuthentication("app", "123456").build();
    }
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public String index(){
        return "redirect:index.html";
    }

    @GetMapping("/user/oauth/token")
    public String token(ServerWebExchange exchang) {
        MultiValueMap<String, String> queryParams = exchang.getRequest().getQueryParams();
        String result = restTemplate.postForObject("http://localhost:8084/oauth/token",queryParams,String.class);

        JsonObject asJsonObject = JsonParser.parseString(result).getAsJsonObject();
        logger.info("授权结果：{}",result);
        Mono<WebSession> session = exchang.getSession();
        CookieWebSessionIdResolver cookieWebSessionIdResolver = new CookieWebSessionIdResolver();
        cookieWebSessionIdResolver.setSessionId(exchang, asJsonObject.get("access_token").getAsString());
        return "redirect:/index.html";
    }
}

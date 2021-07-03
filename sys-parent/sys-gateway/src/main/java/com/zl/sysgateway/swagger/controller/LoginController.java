package com.zl.sysgateway.swagger.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author zhongliang
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return "redirect:index.html";
    }

    @Autowired
    private Docket docket;

    @GetMapping("/user/oauth/token")
    public String token(ServerWebExchange exchange) {
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        String result = restTemplate.postForObject("http://localhost:8093/oauth/token", queryParams, String.class);
        if (result == null) {
            return "redirect:index.html";
        }
        JsonObject asJsonObject = JsonParser.parseString(result).getAsJsonObject();
        logger.info("授权结果：{}", result);
        return "redirect:/swagger-ui/index.html";
    }
}

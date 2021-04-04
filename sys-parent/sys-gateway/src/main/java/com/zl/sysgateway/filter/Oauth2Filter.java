package com.zl.sysgateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author zhongliang
 */
@Component
public class Oauth2Filter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(Oauth2Filter.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<HttpCookie> session = exchange.getRequest().getCookies().get("SESSION");
        if(session== null ||session.isEmpty()){

            return Mono.defer(() -> {
                //设置status
                setStatus(exchange,HttpStatus.UNAUTHORIZED );
                final ServerHttpResponse response = exchange.getResponse();
                byte[] bytes = "{\"code\":\"99000\",\"message\":\"非法访问,没有检测到权限码perm~~~~~~\"}".getBytes();
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                response.getHeaders().set("permValid", "false");//设置header
                response.getHeaders().set("Content-type", "text/html;charset=utf-8");
                logger.info("UrlFilter拦截非法请求，没有检测到权限码perm............");
                return response.writeWith(Flux.just(buffer));//设置body
            });
        }else{
            HttpCookie httpCookie = session.get(0);
            String value = httpCookie.getValue();
            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("token",value);
            String result = restTemplate.postForObject("http://localhost:8084/oauth/check_token",queryParams,String.class);
            logger.debug("检验的token 的结果：{}",result);
            if(StringUtils.isEmpty(result)){
                return Mono.defer(() -> {
                    //设置status
                    setStatus(exchange,HttpStatus.UNAUTHORIZED );
                    final ServerHttpResponse response = exchange.getResponse();
                    byte[] bytes = "{\"code\":\"99000\",\"message\":\"权限码失效~~~~~~\"}".getBytes();
                    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                    //设置header
                    response.getHeaders().set("permValid", "false");
                    response.getHeaders().set("Content-type", "text/html;charset=utf-8");
                    logger.info("UrlFilter拦截非法请求，没有检测到权限码perm............");
                    //设置body
                    return response.writeWith(Flux.just(buffer));
                });
            }
        }
        return chain.filter(exchange);
    }

    private void setStatus(ServerWebExchange exchange, HttpStatus httpStatus){
        //设置status
        exchange.getResponse().setStatusCode(httpStatus);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

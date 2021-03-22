//package com.zl.sysgateway.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//@Configuration
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,proxyTargetClass = true)
//public class SecurityConfiguration  extends ResourceServerConfigurerAdapter {
//
//    private static Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
//
//    private final DiscoveryClient discoveryClient;
//
//    public SecurityConfiguration(DiscoveryClient discoveryClient) {
//        this.discoveryClient = discoveryClient;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry httpSecurity = http
//                .csrf()
//                .disable()
//                .headers()
//                .frameOptions()
//                .disable()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/*/actuator/*").denyAll();
//
//        httpSecurity.antMatchers("/").permitAll();
//        //管控白名单动态配置
//        httpSecurity.anyRequest()
//                .access("@urlWhitelistPassService.access(request,authentication)");
//
//    }
//
//    @Bean
//    public JwtTokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
//        return new JwtTokenStore(jwtAccessTokenConverter);
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter(
//            @Qualifier("loadBalancedRestTemplate") RestTemplate keyUriRestTemplate) {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setVerifierKey(getKeyFromAuthorizationServer(keyUriRestTemplate));
//        return converter;
//    }
//
//    private String getKeyFromAuthorizationServer(RestTemplate keyUriRestTemplate) {
//        // Load available UAA servers
//        discoveryClient.getServices();
//        HttpEntity<Void> request = new HttpEntity<>(new HttpHeaders());
//        return (String) keyUriRestTemplate
//                .exchange("http://sys-uaa/oauth/token_key", HttpMethod.GET, request, Map.class).getBody()
//                .get("value");
//    }
//
//    @Autowired
//    private OAuth2WebSecurityExpressionHandler expressionHandler;
//    @Bean
//    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
//        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
//        expressionHandler.setApplicationContext(applicationContext);
//        return expressionHandler;
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.expressionHandler(expressionHandler);
//    }
//}

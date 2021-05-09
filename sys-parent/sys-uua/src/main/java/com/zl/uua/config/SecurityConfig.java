package com.zl.uua.config;

import com.zl.uua.UserSecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author zhongliang
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler zlAuthenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler zlAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/user/**").formLogin().usernameParameter("username").passwordParameter("password").loginPage("/user/login").successHandler(zlAuthenticationSuccessHandler).failureHandler(zlAuthenticationFailureHandler).and().authorizeRequests().antMatchers("/user/login").permitAll().antMatchers("/user/register").permitAll();
        http.logout().permitAll();
        http.cors().and().csrf().ignoringAntMatchers("/user/**");
        http.logout().logoutUrl("/user/logout").permitAll();
    }

    @Bean
    UserDetailsService UserSecurityService() {
        return new UserSecurityServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UserSecurityService()).passwordEncoder(new BCryptPasswordEncoder());
    }
}

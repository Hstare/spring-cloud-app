/*
package com.hew.springcloudgateway.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/**
 * @author HeXiaoWei
 * @date 2019/12/30 23:04
 *//*

@EnableWebSecurity
public class GatewaySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/static/**","/auth/**","/oauth/**","/oauth2/**",
                        "/resources/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .disable();
    }
}
*/

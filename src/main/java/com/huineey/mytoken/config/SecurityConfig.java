package com.huineey.mytoken.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // csrf 비활성화
                .authorizeRequests()
                .antMatchers("/join", "/login").permitAll() // 검증 없이 접근 허용
                .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN권한 접근 가능
                .antMatchers("/user/**").hasRole("USER") // USER권한 접근 가능
                .anyRequest().authenticated();
    }
}
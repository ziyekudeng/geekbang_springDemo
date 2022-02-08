package com.example.geekbang.spring.class15.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：ROLE_ 前缀与角色
 * ROLE_ 前缀在 Spring Security 前缀中非常重要。
 * @author: gao wei
 * @create: 2022-02-07 21:54
 */

@Configuration
public class C15E2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return Objects.equals(charSequence.toString(), s);
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("fujian").password("pass").roles("USER")
                .and()
                .withUser("admin1").password("pass").roles("ADMIN")
                .and()
                .withUser(new UserDetails() {
                    @Override
                    public Collection getAuthorities() {
                        /*
                         *问题复现:将ROLE_ADMIN改为ADMIN后admin2账号无法登陆
                         */
                        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    } //省略其他非关键“实现”方法

                    @Override
                    public String getPassword() {
                        return "pass";
                    }

                    @Override
                    public String getUsername() {
                        return "admin2";
                    }

                    @Override
                    public boolean isAccountNonExpired() {
                        return false;
                    }

                    @Override
                    public boolean isAccountNonLocked() {
                        return false;
                    }

                    @Override
                    public boolean isCredentialsNonExpired() {
                        return false;
                    }

                    @Override
                    public boolean isEnabled() {
                        return false;
                    }
                });
    }

    // 配置 URL 对应的访问权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/login").permitAll()
                .and()
                .csrf().disable();
    }
}

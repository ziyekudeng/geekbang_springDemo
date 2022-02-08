package com.example.geekbang.spring.class15.example1;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：遗忘 PasswordEncoder
 * @author: gao wei
 * @create: 2022-02-07 21:54
 */

//@Configuration
//public class C15E1WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return Objects.equals(charSequence.toString(), s);
//            }
//        };
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("pass").roles("ADMIN");
//
//    }
//
//    // 配置 URL 对应的访问权限
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/c15/e1/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginProcessingUrl("/login").permitAll()
//                .and().csrf().disable();
//    }
//}

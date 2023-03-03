package com.koreait.restaurant.config;

import com.koreait.restaurant.service.AdminLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AdminLoginService adminLoginService;

    public SecurityConfig(AdminLoginService loginService) {
        this.adminLoginService = loginService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

                http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")

                .and()
                .formLogin()
                .loginPage("/admin/login") // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/admin/access") // 로그인 성공 후 이동 페이지
                .usernameParameter("adminId") // 아이디 파라미터명 설정
                        .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true) //세션 날리기
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminLoginService);
    }
}
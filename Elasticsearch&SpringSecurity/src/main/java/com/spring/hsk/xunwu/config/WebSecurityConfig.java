package com.spring.hsk.xunwu.config;

import com.spring.hsk.xunwu.security.AuthProvider;
import com.spring.hsk.xunwu.security.LoginAuthFailHandler;
import com.spring.hsk.xunwu.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * HTTP权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")   //配置角色登录处理入口
                .failureHandler(loginAuthFailHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/bye")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/errors/403")
                .and();

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint(){
        return new LoginUrlEntryPoint("/user/login");
    }

    @Bean
    public LoginAuthFailHandler loginAuthFailHandler(){
        return new LoginAuthFailHandler(urlEntryPoint());
    }
}

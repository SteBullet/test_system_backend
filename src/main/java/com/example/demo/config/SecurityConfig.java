package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http//.cors().disable()
                .csrf().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**", "/login", "/registration").permitAll();
                    auth.requestMatchers("/wishlist/**", "/games/**").authenticated();
                    auth.requestMatchers(HttpMethod.GET,"/authorities","/genre").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.POST,"/games", "/roles", "/images").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT,"/games").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE,"/games", "/userInfo/**").hasRole("ADMIN");
                    auth.requestMatchers("/link").hasRole("ADMIN");
                })
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().build();

    }
}

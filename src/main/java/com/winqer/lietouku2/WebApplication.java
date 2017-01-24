package com.winqer.lietouku2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.winqer.lietouku2.common.jwt.JwtFilter;


@SpringBootApplication
public class WebApplication {
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/post");

        return registrationBean;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}
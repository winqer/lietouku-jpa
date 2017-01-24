package com.winqer.lietouku2.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("*");
		
		/*registry.addMapping("/api/**")
        .allowedOrigins("http://domain2.com")
        .allowedMethods("PUT", "DELETE")
        .allowedHeaders("header1", "header2", "header3")
        .exposedHeaders("header1", "header2")
        .allowCredentials(false).maxAge(3600);*/
	}


}

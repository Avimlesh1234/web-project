package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
public class CorsConfig {

	  @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();

	        // Allow requests from your Angular application
	        config.addAllowedOrigin("http://localhost:4200"); // Replace with your actual frontend origin
	        config.addAllowedMethod("*");
	        config.addAllowedHeader("*");

	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
}

package com.eptiq.bikebooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Matches all URL patterns
                        .allowedOrigins("http://localhost:5173","http://localhost:5174","https://okbike.vercel.app/","https://okbike-pratiks-projects-602f4c7e.vercel.app/")  // Specifies allowed origin(s)
                        .allowedMethods("*")  // Permits all HTTP methods (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*")  // Allows all headers to be sent
                        .allowCredentials(true);  // Allows credentials like cookies or HTTP authentication
            }
        };
    }
}


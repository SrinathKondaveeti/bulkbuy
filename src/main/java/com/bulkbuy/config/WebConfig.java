package com.bulkbuy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("$$$$$$$$ add Cors Mappings $$$$$$$$$");
        registry.addMapping("/**")
               // .allowedOrigins("http://localhost:4200")
                .allowedOrigins("https://srinathkondaveeti.github.io")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)                     // set false if allowedOrigins="*"
                .maxAge(3600);
    }

}

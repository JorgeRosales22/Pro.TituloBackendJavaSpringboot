package com.ComexUp.Aplicacion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Cambia esto al dominio de tu aplicación front-end
                .allowedMethods("GET", "POST", "PATCH", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

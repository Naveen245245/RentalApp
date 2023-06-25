package com.navin.rentalapp.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info( new Info().title("RENTAL SYSTEM REST API clone")
                .description("API for rental system vehicles, stores, reservations bills and payments.")
                .version("0.0.1"));
    }
}

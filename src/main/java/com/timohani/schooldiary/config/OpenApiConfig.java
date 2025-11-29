package com.timohani.schooldiary.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI schoolDiaryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("School Diary API")
                        .description("API для электронного школьного дневника")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tihon")
                                .email("tihon.backend@gmail.com")));
    }
}
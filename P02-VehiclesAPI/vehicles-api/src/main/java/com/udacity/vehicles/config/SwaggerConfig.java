package com.udacity.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cars-service")
                .apiInfo(metadata())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/cars/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Vehicles API")
                .description("REST CRUD API for querying & managing Vehicles information")
                .version("1.0.0")
                .termsOfServiceUrl("http://www.udacity.com/tos")
                .contact(new Contact("Krupesh Anadkat", "https://krupeshanadkat.com", "krupeshanadkat16@gmail.com"))
                .license("Creative Commons 3.0")
                .licenseUrl("https://github.com/kmanadkat/udnd-java-prj2-car-be?tab=License-1-ov-file#readme")
                .build();
    }

}
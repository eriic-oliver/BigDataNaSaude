package com.apirest.bigdatanasaude.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apirest.bigdatanasaude"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Big Data Na Área da Saúde API REST",
                "Protótipo de API REST para um Big Data voltado a área de saúde, com fins acadêmicos",
                "1.0",
                "Terms of Service",
                new Contact("Eric Oliveira e Murilo Souza",
                        "https://github.com/eriic-oliver/BigDataNaSaude",
                        "eriic.oliv@gmail.com e murilo2554@gmail.com"),
                "Apache Licence Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}

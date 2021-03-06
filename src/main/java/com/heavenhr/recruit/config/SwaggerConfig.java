package com.heavenhr.recruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/recruit-service/.*")).build().apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("HeavenHR Recruit REST API",
                "REST API Service Dashboard.", 
                "1",
                "",
                "HeavenHR", 
                "", 
                "");
        return apiInfo;
    }
}
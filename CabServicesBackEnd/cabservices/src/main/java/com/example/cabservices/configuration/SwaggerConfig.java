package com.example.cabservices.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2 
public class SwaggerConfig {
//   @Bean
//		    public Docket api() {
//		        return new Docket(DocumentationType.SWAGGER_2)
//	        		. apiInfo(metadata()).select().paths(regex("/api.*")).build();
//		}

			@SuppressWarnings("unused")
			private ApiInfo metadata() {
			return new ApiInfoBuilder().title("Capgemini").description("API reference guide for developers").termsOfServiceUrl("https://www.cg.com/").build();	
			}
		}



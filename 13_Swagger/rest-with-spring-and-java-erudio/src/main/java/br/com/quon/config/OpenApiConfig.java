package br.com.quon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		
		
		return new OpenAPI()
				.info(new Info()
						.title("Api Spring JAVA 17")
						.version("1.0.0")
						.description("about api")
						.termsOfService("https://matheus1221.github.io/Matheus-site/")
						.license(
							new License()
								.name("Aoache 2.0")
								.url("https://matheus1221.github.io/Matheus-site/")));
								
			
	}

}

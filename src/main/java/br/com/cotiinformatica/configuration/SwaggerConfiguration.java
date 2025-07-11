package br.com.cotiinformatica.configuration;


import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfiguration {
	@Bean
	OpenAPI customOpenApi() {
		var openApi = new OpenAPI().components(new Components())
						.info(new Info()
						.title("API Pedidos - Treinamento TJ/PR Turma 02")	
						.description("Curso de java da turma 2")
						.version("v1"));
		return openApi;
	}

}

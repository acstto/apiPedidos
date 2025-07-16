package br.com.cotiinformatica.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
	@Bean
	ModelMapper getModelMapper() {
		var mapper = new ModelMapper();
		return mapper;
	}

}

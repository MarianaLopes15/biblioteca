package br.com.aceleragep.biblioteca.configs.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("br.com.aceleragep").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI forumAluraOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Biblioteca API").description("Projeto de Documentacao da API da Biblioteca")
						.version("v0.0.1").license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));
				
	}
}

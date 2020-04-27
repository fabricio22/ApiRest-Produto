package br.com.school.api;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket apiConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(infoDocs())
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.school.api.resources"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo infoDocs() {
		return new ApiInfo(" Api - Cadastro de Produto", "Esta é uma Api de cadastro de produto", "1.0", "Termos",
				new Contact("Fabricio Nascimento Pires", "", "Fanpir13@hotmail.com"), "Apache License", "URL",
				new ArrayList<VendorExtension>());
	}
}

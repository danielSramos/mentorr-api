package br.com.unifap.mentorr.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mentorr Restful API")
                        .description("Mentorr API documentation with Swagger and OpenAPI")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Daniel S. Ramos")
                                .email("danieldsrce@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation().description("Full Documentation").url("https://localhost:8080/docs"));
    }
}

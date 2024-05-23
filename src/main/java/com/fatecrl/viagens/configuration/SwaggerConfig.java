package com.fatecrl.viagens.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI financasOpenAPI() {
     return new OpenAPI().info(new Info()
        .title("API do Projeto de Viagens")
        .description("Esta API é utilizada no projeto final da disciplina Desenvolvimento para Servidores-II")
        .version("v0.0.1")
        .contact(new Contact()
          .name("Barbara Hellen, Bruna Costa e Nathália Regina").email("equipecalendall@fatec.com"))
        .license(new License()
          .name("Apache 2.0").url("http://springdoc.org")));
  }
}


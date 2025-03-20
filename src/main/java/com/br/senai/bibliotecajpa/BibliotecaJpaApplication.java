package com.br.senai.bibliotecajpa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
        title = "${info.build.name}",
        version = "${info.build.version}",
        description = "${info.app.description}",
        contact = @Contact(
            name = "Time Arquitetura e APIs",
            email = "ruanp9725@gmail.com"
        )
    )
)
@SpringBootApplication
public class BibliotecaJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaJpaApplication.class, args);
    }

}
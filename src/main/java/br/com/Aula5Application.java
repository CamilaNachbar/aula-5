package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = { "br.com.entity.**", "br.com.repository.**", "br.com.controller.**", "br.com.service.**",
		"br.com.serviceImpl", "br.com.exception" })
public class Aula5Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula5Application.class, args);
	}

}

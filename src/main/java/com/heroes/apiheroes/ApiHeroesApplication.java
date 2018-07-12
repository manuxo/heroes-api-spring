package com.heroes.apiheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.heroes.apiheroes.model.entities")
public class ApiHeroesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiHeroesApplication.class, args);
    }
}

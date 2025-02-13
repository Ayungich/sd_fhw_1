package com.ayungi.softwaredesign.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

// Spring-конфигурация
@Configuration
@ComponentScan({"com.ayungi.softwaredesign"})
public class AppConfig {
    // Регистрируем Scanner как bean (синглтон)
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}

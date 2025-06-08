package com.lawal.transitcraft;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppRunner {

    public static void main(String[] args) {
        // Delegate startup to the MainApp
        MainApp.runApplication(args);
    }

    @Bean
    public ApplicationRunner onStart() {
        return args -> {
            System.out.println("Spring Boot ApplicationRunner: Transit service initialized");
        };
    }

    @Bean
    public CommandLineRunner onCommandLineStart() {
        return args -> {
            System.out.println("Command Line Runner executed!");
        };
    }
}
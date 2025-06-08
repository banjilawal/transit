package com.lawal.transitcraft;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApp {

    private static ConfigurableApplicationContext springContext;

    public static void runApplication(String[] args) {
        // Start Spring Boot context
        springContext = SpringApplication.run(SpringAppRunner.class, args);

        // Pass the Spring Context to JavaFX application
        JavaFXAppRunner.setSpringContext(springContext);

        // Launch JavaFX Application
        Application.launch(JavaFXAppRunner.class, args);
    }

    public static void main(String[] args) {
        runApplication(args);
    }
}
package com.lawal.transit;

import javafx.application.Platform;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApp {

    private static ConfigurableApplicationContext springContext;

    public static void runApplication(String[] args) {
        // Start Spring Boot context
        springContext = SpringApplication.run(SpringAppRunner.class, args);

        // Launch JavaFX Application
        Platform.startup(() -> {
            JavaFXAppRunner.setSpringContext(springContext); // Pass Spring Context to JavaFX
            JavaFXAppRunner.launch(JavaFXAppRunner.class, args); // Start JavaFX app
        });
    }

    public static void main(String[] args) {
        runApplication(args);
    }
}
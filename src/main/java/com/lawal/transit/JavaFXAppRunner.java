package com.lawal.transit;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

public class JavaFXAppRunner extends Application {

    private static ApplicationContext springContext;

    // Inject Spring Context
    public static void setSpringContext(ApplicationContext context) {
        springContext = context;
    }

    @Override
    public void start(Stage primaryStage) {
        // Example: Retrieve a Spring-managed service
        TransitService transitService = springContext.getBean(TransitService.class);

        // Call some Spring-managed logic
        System.out.println("Spring Bean says: " + transitService.getWelcomeMessage());

        primaryStage.setTitle("Transit Application");
        primaryStage.show();

        System.out.println("JavaFX Application running...");
    }
}
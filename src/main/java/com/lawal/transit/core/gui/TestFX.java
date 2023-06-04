package com.lawal.transit.core.gui;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TestFX {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick () {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
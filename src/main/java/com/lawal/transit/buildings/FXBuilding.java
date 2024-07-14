package com.lawal.transit.buildings;


import com.lawal.transit.fx.*;
import com.lawal.transit.globals.*;

import javafx.scene.*;
import javafx.scene.control.*;

public class FXBuilding extends Node implements FXAddressableControl {
    private final Addressable addressable;
    private final Button button;
    private final StylerInterface styler;

    public FXBuilding (
        Addressable addressable,
        StylerInterface styler
    ) {
        this.addressable = addressable;
        this.button = new Button(addressable.getAddress().toString());
        this.button.setStyle(styler.toString());
        this.styler = styler;
    }

    @Override
    public Addressable getAddressable () {
        return addressable;
    }

    @Override
    public Button getButton () {
        return button;
    }

    @Override
    public StylerInterface getStyler () {
        return styler;
    }

//    private String defaultCSS () {
//        return "-fx-fill: c9c3ed;"
//            + " -fx-padding: 5 5;"
//            + " -fx-width: 100;"
//            + " -fx-height: 40;";
//      return "-fx-fill: lightblue;" +
//          "-fx-background-color: #c9c3ed; " + //#3498db; " +
//            "-fx-text-fill: white; " +
//            "-fx-font-size: 14px; " +
//        "-fx-padding: 5px 5px; " +
//        "-fx-border-color: #2980b9; " +
//        "-fx-border-width: 2px; " +
//        "-fx-border-radius: 5px; " +
//        "-fx-background-radius: 5px;";
//    }
//
//    private static Shape shapeHelper (double xCoordinate, double yCoordinate, double width, double height, Color color) {
//        Rectangle rectangle =  new Rectangle(xCoordinate, yCoordinate, width, height);
//        rectangle.setFill(color);
//        return rectangle;
//    }
}

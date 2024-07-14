package com.lawal.transit.stations;


import com.lawal.transit.fx.*;
import com.lawal.transit.graph.interfaces.*;
import javafx.scene.*;
import javafx.scene.control.*;

public class FXStation extends Node implements FXVertexControl {

    private final Vertex station;
    private final Button button;
    private final StylerInterface styler;

    public FXStation (Vertex station, StylerInterface styler) {
        this.station  = station;
        this.button = new Button(station.getAddress().toString());
        this.button.setStyle(styler.toString());
        this.styler = styler;
    }

    @Override
    public Vertex getVertex () {
        return station;
    }

    @Override
    public Button getButton () {
        return button;
    }

    @Override
    public StylerInterface getStyler () {
        return styler;
    }


    private String defaultCSS () {
        return "-fx-fill: white"
            + "-fx-padding:  5; "
            + "fx-width: 30; "
            + "fx-height: 30;";
    }
//
//    private static Shape shapeHelper (double xCoordinate, double yCoordinate, double width, double height, Color color) {
//        Rectangle rectangle =  new Rectangle(xCoordinate, yCoordinate, width, height);
//        rectangle.setFill(color);
//        return rectangle;
//    }
}

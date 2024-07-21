package com.lawal.transit.stations;


import com.lawal.transit.fx.*;
import com.lawal.transit.graph.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;

public class FXStation extends Node implements FXVertexControl {
    private final Stylerizerable stylerizer;
    private final Vertex station;
    private final Button button;


    public FXStation (Vertex station, Stylerizerable stylerizer) {
        this.station  = station;
        this.stylerizer = stylerizer;
        this.button = new Button(station.getAddress().getName());
        this.button.alignmentProperty().set(Pos.CENTER);
        this.button.wrapTextProperty().setValue(true);
        this.button.setStyle(stylerizer.toString());
        this.button.setTooltip(new Tooltip(station.getAddress().getRoadIdentity().toString() + station.getAddress().getOrientation().abbreviation()));
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
    public Stylerizerable getStylerizer () {
        return stylerizer;
    }

//    private String defaultCSS () {
//        return "-fx-fill: white"
//            + "-fx-padding:  5; "
//            + "fx-width: 30; "
//            + "fx-height: 30;";
//    }
//
//    private static Shape shapeHelper (double xCoordinate, double yCoordinate, double width, double height, Color color) {
//        Rectangle rectangle =  new Rectangle(xCoordinate, yCoordinate, width, height);
//        rectangle.setFill(color);
//        return rectangle;
//    }
}

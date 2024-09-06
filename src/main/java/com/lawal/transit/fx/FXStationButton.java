//package com.lawal.transit.fx;
//
//
//import com.lawal.transit.fx.*;
//import com.lawal.transit.fx.interfaces.*;
//import com.lawal.transit.graph.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//
//public class FXStationButton extends Node implements VertexFXControllable {
//    private final OldStationable station;
//    private final Button button;
//
//
//    public FXStationButton (OldStationable station) {
//        this.station  = station;
//        FormattedAddress address = station.getAddress();
//        String toolTipText = address.getRoadIdentity().getName() + " " + address.getOrientation().abbreviation();
//        this.button = new Button(address.getName());
//        this.button.alignmentProperty().set(Pos.CENTER);
//        this.button.wrapTextProperty().setValue(true);
//        this.button.setTooltip(new Tooltip(toolTipText));
//        this.button.setStyle(cssStyling());
//    }
//
//    @Override
//    public OldStationable getVertex () {
//        return station;
//    }
//
//    @Override
//    public Button getButton () {
//        return new ButtonBuilder().build(station);
//    }
//
////    public String cssStyling () {
//        String backgroundStyle = " -fx-background-color: white;"
//            + " -fx-background-insets: 3;"
//            + " -fx-background-radius: 2;"
//            + " -fx-width: 400;"
//            + " -fx-height: 400;";
//        String borderStyle = " -fx-border-color: black;"
//            + " -fx-border-style: solid;"
//            + " -fx-border-width: 3;"
//            + " -fx-border-radius: 2;"
//            + " -fx-border-insets: 3";
//        return backgroundStyle + borderStyle;
//    }
//
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
//}
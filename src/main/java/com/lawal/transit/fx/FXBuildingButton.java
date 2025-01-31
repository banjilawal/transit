//package com.lawal.transit.fx;
//
//
//import com.lawal.transit.places.*;
//import com.lawal.transit.fx.interfaces.*;
//
//import javafx.scene.*;
//import javafx.scene.control.*;
//
//public class FXBuildingButton extends Node implements AddressableFXControlable {
//
//    private final AddressEntity addressable;
//    private final Button button;
//
//    public FXBuildingButton (AddressEntity addressable) {
//        this.addressable = addressable;
//        FormattedAddress address = addressable.getAddress();
//        String title = address.getName() + "\n"
//            + address.getRoadIdentity().getName()
//            + address.getOrientation().abbreviation();
//        this.button = new Button(title);
//        this.button.setWrapText(true);
//        this.button.setStyle(cssStyling());
//        this.button.alignmentProperty().set(Pos.CENTER);
//        this.button.setTooltip(new Tooltip(addressable.toString()));
//    }
//
//    @Override
//    public AddressEntity getAddressable () {
//        return addressable;
//    }
//
//    @Override
//    public Button getButton () {
//        return new ButtonBuilder().build(addressable);
//    }
//    public String cssStyling () {
//        String backgroundStyle = " -fx-background-color: lightblue;"
//            + " -fx-background-insets: 2;"
//            + " -fx-background-radius: 1;"
//            + " -fx-width: 500;"
//            + " -fx-height: 400;";
//        String borderStyle = " -fx-border-color: black;"
////            + " -fx-border-style: dashed;"
//            + " -fx-border-width: 1;"
//            + " -fx-border-radius: 1;"
//            + " -fx-border-insets: 1";
//        return backgroundStyle +  borderStyle;
//    }
//
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
//}
//package com.lawal.transit.ui;
//
//import com.lawal.transit.places.*;
//import com.lawal.transit.ui.interfaces.*;
//import javafx.beans.property.*;
//import javafx.scene.paint.*;
//import javafx.scene.shape.*;
//
//public class BuildingShape implements ShapeableAddressable {
//
//    public static final Color DEFAULT_COLOR = Color.BLUE;
//    public static String DIMENSION_ERROR_MESSAGE = "Instance creation failed: A dimensional parameter cannot be negative";
//
//    private final AddressEntity addressable;
//    private final Shape shape;
//
//    public BuildingShape (
//        AddressEntity addressable,
//        double xCoordinate,
//        double yCoordinate,
//        double width,
//        double height
//    ) throws Exception {
//        if (xCoordinate < 0 || yCoordinate < 0 || width < 0 || height < 0)
//            throw new Exception(DIMENSION_ERROR_MESSAGE);
//        this.addressable = addressable;
//        this.shape = shapeHelper(xCoordinate, yCoordinate, width, height);
//    }
//
//    @Override
//    public StringProperty addressProperty () {
//        return new SimpleStringProperty(addressable.address().toString());
//    }
//
//    @Override
//    public AddressEntity getAddressable () {
//        return addressable;
//    }
//
//    @Override
//    public Shape shape () {
//        return shape;
//    }
//
//    private static Shape shapeHelper (double xCoordinate, double yCoordinate, double width, double height) {
//        Shape shape = new Rectangle(xCoordinate, yCoordinate, width, height);
//        shape.setFill(DEFAULT_COLOR);
//        return shape;
//    }
//}
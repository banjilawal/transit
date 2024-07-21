package com.lawal.transit.ui;

import com.lawal.transit.globals.*;
import javafx.beans.property.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

//public class ShapedVertex implements ShapeableAddressable {
//
//    public static final Color DEFAULT_COLOR = Color.WHITESMOKE;
//    public static String DIMENSION_ERROR_MESSAGE = "Instance creation failed: A dimensional parameter cannot be negative";
//
//    private final Vertex vertex;
//    private final Shape shape;
//
//    public ShapedVertex (
//        Vertex vertex,
//        double centerX,
//        double centerY,
//        double radius
//    ) throws Exception {
//        if (centerX < 0 || centerY < 0 || radius < 0)
//            throw new Exception(DIMENSION_ERROR_MESSAGE);
//        this.vertex = vertex;
//        this.shape = shapeHelper(centerX, centerY, radius);
//    }
//
//    @Override
//    public StringProperty addressProperty () {
//        return new SimpleStringProperty(vertex.getAddress().toString());
//    }
//
//    @Override
//    public Addressable getAddressable () {
//        return vertex.getAddress();
//    }
//
//
//    @Override
//    public Shape shape () {
//        return shape;
//    }
//
//    private static Shape shapeHelper (double centerX, double centerY, double radius) {
//        Shape shape = new Circle(centerX, centerY, radius);
//        shape.setFill(DEFAULT_COLOR);
//        return shape;
//    }
//}

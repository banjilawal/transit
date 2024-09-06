//package com.lawal.transit.fx;
//
//import javafx.scene.paint.*;
//
//import java.util.*;
//
//public final class ShapeDetails {
//
//    private final double startingX;
//    private final double startingY;
//    private final double width;
//    private final double height;
//    private final Color color;
//
//    public ShapeDetails (double startingX, double startingY, double width, double height, Color color) {
//        this.startingX = startingX;
//        this.startingY = startingY;
//        this.width = width;
//        this.height = height;
//        this.color = color;
//    }
//
//    public double getStartingX () {
//        return startingX;
//    }
//
//    public double getStartingY () {
//        return startingY;
//    }
//
//    public double getWidth () {
//        return width;
//    }
//
//    public double getHeight () {
//        return height;
//    }
//
//    public Color getColor () {
//        return color;
//    }
//
//    @Override
//    public boolean equals (Object object) {
//        if (object == this) return true;
//        if (object == null) return false;
//        if (object instanceof  ShapeDetails properties) {
//            return startingX == properties.getStartingX() && startingY == properties.getStartingY()
//                && width == properties.getWidth() && height == properties.getHeight()
//                && color.equals(properties.getColor());
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode () {
//        return Objects.hash(startingX, startingY, width, height, color);
//    }
//
//    @Override
//    public String toString () {
//        return "ShapeDetails{" +
//            "startingX:" + startingX +
//            ", startingY:" + startingY +
//            ", width:" + width +
//            ", height:" + height +
//            ", color:" + color +
//            '}';
//    }
//}
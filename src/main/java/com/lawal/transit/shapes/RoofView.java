package com.lawal.transit.shapes;

import javafx.beans.property.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.lang.reflect.*;
import java.util.*;

public class RoofView {

//    public static final int TOTAL_RECTANGLE_POINTS = 5;
//    public static final int TOTAL_TRIANGLE_POINTS = 4;
    public static final double TRIANGLE_ANGLE = 45.00;
    public static final double RADIANS = TRIANGLE_ANGLE * Math.PI / 180;

    private final double width;
    private final double height;
    private final double startingX;
    private final double startingY;
    private final double adjacentLength;
    private final double oppositeLength;
    private final StringProperty address;
    private final Color triangleColor;
    private final Color rectangleColor;
    private final ArrayList<LineTo> rectanglePoints;
    private final ArrayList<LineTo> leftTrianglePoints;
    private final ArrayList<LineTo> rightTrianglePoints;


    public RoofView (
        double width,
        double height,
        double startingX,
        double startingY,
        StringProperty address,
        Color triangleColor,
        Color rectangleColor
    ) {
        this.width = width;
        this.height = height;
        this.startingX = startingX;
        this.startingY = startingY;
        this.address = address;
        this.triangleColor = triangleColor;
        this.rectangleColor = rectangleColor;

        this.adjacentLength = Math.abs(height / 2);
        this.oppositeLength = Math.abs(Math.tan(RADIANS) * adjacentLength);

        this.rectanglePoints = setRectanglePoints();
        this.leftTrianglePoints = setLeftTrianglePoints();
        this.rightTrianglePoints = setRightTrianglePoints(rectanglePoints.get(1).getX(), rectanglePoints.get(1).getY());
    }

    public double getWidth () {
        return width;
    }

    public double getHeight () {
        return height;
    }

    public double getStartingX () {
        return startingX;
    }

    public double getStartingY () {
        return startingY;
    }

    public StringProperty getAddress () {
        return address;
    }

    public StringProperty addressProperty () {
        return address;
    }

    public Color getTriangleColor () {
        return triangleColor;
    }

    public Color getRectangleColor () {
        return rectangleColor;
    }

    public ArrayList<LineTo> getRectanglePoints () {
        return rectanglePoints;
    }

    public ArrayList<LineTo> getLeftTrianglePoints () {
        return leftTrianglePoints;
    }

    public ArrayList<LineTo> getRightTrianglePoints () {
        return rightTrianglePoints;
    }

    private ArrayList<LineTo> setRectanglePoints () {
        ArrayList<LineTo> points = new ArrayList<>();
        points.add(points.size(), new LineTo(startingX, startingY));
        points.add(points.size(), new LineTo(startingX + width, startingY));
        points.add(points.size(), new LineTo(points.get(1).getX(), startingY + height));
        points.add(points.size(), new LineTo(points.get(2).getX() - width, points.get(2).getY()));
        points.add(points.size(), new LineTo(startingX, startingY));
        return points;
    }

    private ArrayList<LineTo> setLeftTrianglePoints () {
        ArrayList<LineTo> points = new ArrayList<>();
        points.add(points.size(), new LineTo(startingX, startingY));
        points.add(points.size(), new LineTo(startingX + oppositeLength, startingY - adjacentLength));
        points.add(points.size(), new LineTo(rectanglePoints.get(3).getX(), rectanglePoints.get(3).getY()));
        points.add(points.size(), new LineTo(startingX, startingY));
        return points;
    }

    private ArrayList<LineTo> setRightTrianglePoints (double startingX, double startingY) {
        ArrayList<LineTo> points = new ArrayList<>();
        points.add(points.size(), new LineTo(rectanglePoints.get(1).getX(), rectanglePoints.get(1).getY()));
        points.add(points.size(), new LineTo(rectanglePoints.get(2).getX(), rectanglePoints.get(2).getY()));
        points.add(points.size(), new LineTo(rectanglePoints.get(1).getX() - oppositeLength, rectanglePoints.get(1).getY() - adjacentLength));
        points.add(points.size(), new LineTo(rectanglePoints.get(1).getX(), rectanglePoints.get(1).getY()));
        return points;
    }

}

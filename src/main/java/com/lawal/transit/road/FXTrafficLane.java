package com.lawal.transit.road;

import com.lawal.transit.fx.*;
import com.lawal.transit.road.interfaces.*;
import javafx.scene.shape.*;

public class FXTrafficLane implements ShapeableLane {

    private final Lane lane;
    private final double width;
    private final double height;
    private final double startingX;
    private final double startingY;
    private final StylerInterface styler;
    private final Shape shape;

    public FXTrafficLane (
        Lane lane,
        double width,
        double height,
        double startingX,
        double startingY,
        StylerInterface styler
    ) {
        this.lane = lane;
        this.width = width;
        this.height = height;
        this.startingX = startingX;
        this.startingY = startingY;
        this.styler = styler;
        this.shape = new Rectangle(startingX, startingY, startingX + width, startingY + height);
        this.shape.setStyle(styler.toString());
    }

    @Override
    public Lane getLane () {
        return lane;
    }

    @Override
    public double getWidth () {
        return width;
    }

    @Override
    public double getHeight () {
        return height;
    }

    @Override
    public double getStartingX () {
        return startingX;
    }

    @Override
    public double getStartingY () {
        return startingY;
    }

    @Override
    public Shape getShape () {
        return shape;
//        Rectangle rectangle = new Rectangle(startingX, startingY, startingX + width, startingY + height);
//        rectangle.setStyle(styler.toString());
//        rectangle.setFill(Color.LIGHTGRAY);
//        return rectangle;
    }

    @Override
    public StylerInterface getStyler () {
        return styler;
    }
}

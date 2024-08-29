package com.lawal.transit.fx;

import com.lawal.transit.fx.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

import java.util.*;

public class CarriagewayFX implements LaneCollectionFXWrapper {

    private final Lanes lanes;
    private final ShapeDetails shapeDetails;
//    private final double startingX;
//    private final double startingY;
//    private final double width;
//    private final double height;
    private final double spacing;

    public CarriagewayFX (
        Lanes lanes, ShapeDetails shapeDetails, double spacing) {
//        double startingX,
//        double startingY,
//        double width,
////        double height,
//        double spacing
//    ) {
        this.lanes = lanes;
        this.shapeDetails = shapeDetails;
//        this.startingX = startingX;
//        this.startingY = startingY;
//        this.width = width;
//        this.height = height;
        this.spacing = spacing;
    }

    @Override
    public Lanes getLanes () {
        return lanes;
    }

    @Override
    public double getSpacing () {
        return spacing;
    }

    @Override
    public ShapeDetails getShapeDetails () {
        return shapeDetails;
    }

    @Override
    public HBox getHBox () {
        HBox hBox = new HBox();
        double x = shapeDetails.getStartingX();
        double y = shapeDetails.getStartingY();
        Iterator<Lane> iterator = lanes.iterator();
        while (iterator.hasNext()) {
            Lane lane = iterator.next();
            Rectangle rectangle = new Rectangle(x,  y, shapeDetails.getWidth(), shapeDetails.getWidth());
            rectangle.setFill(shapeDetails.getColor());
            rectangle.setStyle(Styling.RECTANGLE_CSS);
            hBox.getChildren().addAll(new TrafficLaneFX(lane, rectangle).hBox());
            x += spacing;
            y += spacing;
        }
        return hBox;
    }

    @Override
    public VBox getVBox () {
        VBox vBox = new VBox();
        double x = shapeDetails.getStartingX();
        double y = shapeDetails.getStartingY();
        Iterator<Lane> iterator = lanes.iterator();
        while (iterator.hasNext()) {
            Lane lane = iterator.next();
            Rectangle rectangle = new Rectangle(x,  y, shapeDetails.getWidth(), shapeDetails.getWidth());
            rectangle.setFill(shapeDetails.getColor());
            rectangle.setStyle(Styling.RECTANGLE_CSS);
            vBox.getChildren().addAll(new TrafficLaneFX(lane, rectangle).vBox());
            x += spacing;
            y += spacing;
        }
        return vBox;
    }
}

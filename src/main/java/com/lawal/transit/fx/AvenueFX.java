package com.lawal.transit.fx;

import com.lawal.transit.fx.interfaces.*;
import com.lawal.transit.roads.*;
import javafx.scene.*;
import javafx.scene.layout.*;

public class AvenueFX implements AvenueFXWrapper {

    private final Avenue avenue;
    private final ShapeDetails shapeDetails;
    private final double spacing;

    public AvenueFX (Avenue avenue, ShapeDetails shapeDetails, double spacing) {
        this.avenue = avenue;
        this.shapeDetails = shapeDetails;
        this.spacing = spacing;
    }

    @Override
    public Avenue getAvenue () {
        return avenue;
    }

    public ShapeDetails getShapeDetails () {
        return shapeDetails;
    }

    public double getSpacing () {
        return spacing;
    }

    @Override
    public VBox getVbox () {
        VBox avenueBox = new VBox();
        avenueBox.getChildren().addAll(new Group(getLeftPane()), new Group(getRightPane()));
        return avenueBox;
    }

    public VBox getLeftPane () {
        VBox leftVBox = new VBox();
        leftVBox.getChildren().addAll(
            new FrontagePaneBuilder(avenue.leftFrontage()).getVBox(),
            new CarriagewayFX(avenue.leftCarriageway(), shapeDetails, spacing).getVBox()
        );
        return leftVBox;
    }

    public VBox getRightPane () {
        VBox rightVBox = new VBox();
        rightVBox.getChildren().addAll(
            new FrontagePaneBuilder(avenue.rightFrontage()).getVBox(),
            new CarriagewayFX(avenue.rightCarriageway(), shapeDetails, spacing).getVBox()
        );
        return rightVBox;
    }
}

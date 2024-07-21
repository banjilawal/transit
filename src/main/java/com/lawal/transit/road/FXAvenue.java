package com.lawal.transit.road;

import com.lawal.transit.buildings.*;
import com.lawal.transit.fx.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.stations.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.*;

public final class FXAvenue {

    private final Avenue avenue;
    StylerizerFactory factory;
    private final Group group;
    private final Pane pane;

    public FXAvenue (Avenue avenue) {
        this.avenue = avenue;
        this.factory = new StylerizerFactory();
        this.group = new Group();
        this.pane = new HBox();
        this.pane.setStyle(
            "-fx-background-color: black; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed; "
        );
        pane.getChildren().addAll(group);
    }


    public Avenue getAvenue () {
        return avenue;
    }

    public Group getGroup () {
        return group;
    }

    public VBox getVbox () {
        VBox vBox = new VBox(new Group(getLeftBox()), new Group(getRightBox()));
        vBox.setStyle(
            "-fx-background-color: black; -fx-padding: 1; -fx-border-border-color: red; "
        );
        return vBox;
    }

    private VBox getLeftBox () {
        VBox box = new VBox(getLeftBuildingButtonBar(), getLeftStationButtonBar());
        box.setStyle("-fx-background-color: green; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed");
        return box;
    }

    private VBox getRightBox () {
        VBox box = new VBox(getRightBuildingButtonBar(), getRightStationButtonBar());
        box.setStyle("-fx-background-color: green; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed");
        return box;
    }

    private ButtonBar getLeftButtonBar () {
        StylerizerFactory factory = new StylerizerFactory();
        ButtonBar buttonBar = new ButtonBar();
        Iterator<Addressable> buildingIterator = avenue.getLeftSideBuildings().iterator();
        while (buildingIterator.hasNext()) {
            FXBuilding fxBuilding = new FXBuilding(buildingIterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
        }

        Iterator<Vertex> stationIterator = avenue.getLeftSideStations().iterator();
        while (stationIterator.hasNext()) {
            FXStation fxStation = new FXStation(stationIterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
        }
        return buttonBar;
    }

    private ButtonBar getLeftBuildingButtonBar () {
        ButtonBar buttonBar = new ButtonBar();
        Iterator<Addressable> iterator = avenue.getLeftSideBuildings().iterator();
        while (iterator.hasNext()) {
            FXBuilding fxBuilding = new FXBuilding(iterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
        }
        return buttonBar;
    }

    private ButtonBar getLeftStationButtonBar () {
        ButtonBar buttonBar = new ButtonBar();
        Iterator<Vertex> iterator = avenue.getLeftSideStations().iterator();
        while (iterator.hasNext()) {
            FXStation fxStation = new FXStation(iterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
        }
        return buttonBar;
    }

    private ButtonBar getRightBuildingButtonBar () {
        ButtonBar buttonBar = new ButtonBar();
        Iterator<Addressable> iterator = avenue.getRightSideBuildings().iterator();
        while (iterator.hasNext()) {
            FXBuilding fxBuilding = new FXBuilding(iterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
        }
        return buttonBar;
    }

    private ButtonBar getRightStationButtonBar () {
        ButtonBar buttonBar = new ButtonBar();
        Iterator<Vertex> iterator = avenue.getRightSideStations().iterator();
        while (iterator.hasNext()) {
            FXStation fxStation = new FXStation(iterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
        }
        return buttonBar;
    }

//    @Override
//    public StylerizerableFactorable getStylerizerFactory () {
//        return null;
//    }
//    private final RectangleDimension dimension;
//    private final StylerizerableFactorable stylerizerFactory;
//
//    public FXTrafficLane (
//        Lane lane,
//        RectangleDimension dimension,
//        StylerizerableFactorable stylerizerFactory
//
//    ) {
//        this.lane = lane;
//        this.dimension = dimension;
//        this.stylerizerFactory = stylerizerFactory;
////        this.shape = new Rectangle(
////            dimension.getCoordinate().getX(),
////            dimension.getCoordinate().getY(),
////            dimension.getWidth(),
////            dimension.getHeight()
////        );
////        this.shape.setFill(Color.GRAY);
////        this.shape.setStroke(Color.WHITE);
////        this.shape.setStrokeType(StrokeType.OUTSIDE);
////        this.shape.autosize();
////        this.shape.setStyle(stylerizerFactory.stylerizer(ComponentCategory.LANE).toString());
////        this.dimension = dimension;
//    }
//
//    @Override
//    public Lane getLane () {
//        return lane;
//    }
//
//    @Override
//    public RectangleDimension getDimension () {
//        return dimension;
//    }
//
////    @Override
////    public Shape getShape () {
////        return shape;
////        Rectangle rectangle = new Rectangle(startingX, startingY, startingX + width, startingY + height);
////        rectangle.setStyle(styler.toString());
////        rectangle.setFill(Color.LIGHTGRAY);
////        return rectangle;
////    }
//
//    @Override
//    public StylerizerableFactorable getStylerizerFactory () {
//        return stylerizerFactory;
//    }
//
//    public ButtonBar getBUildingButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<Addressable> iterator = lane.getBuildings().iterator();
//        while (iterator.hasNext()) {
//            buttonBar.getButtons().add(
//                buttonBar.getButtons().size(),
//                new FXBuilding(iterator.next(),
//                stylerizerFactory.stylerizer(ComponentCategory.ADDRESSABLE)).getButton()
//            );
//        }
//        return buttonBar;
//    }
//
//    public ButtonBar getStationButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<Vertex> iterator = lane.getStations().iterator();
//        while (iterator.hasNext()) {
//            buttonBar.getButtons().add(
//                buttonBar.getButtons().size(),
//                new FXStation(iterator.next(),
//                stylerizerFactory.stylerizer(ComponentCategory.VERTEX)).getButton()
//            );
//        }
//        return buttonBar;
//    }
//
//    public Rectangle getRectangle () {
//        Rectangle rectangle = new Rectangle(
//            dimension.getCoordinate().getX(),
//            dimension.getCoordinate().getY(),
//            dimension.getWidth(),
//            dimension.getHeight()
//        );
//        rectangle.autosize();
//        rectangle.setFill(Color.GRAY);
//        rectangle.setStroke(Color.WHITE);
//        rectangle.setStrokeType(StrokeType.OUTSIDE);
//        rectangle.setStyle(stylerizerFactory.stylerizer(ComponentCategory.LANE).toString());
//        return rectangle;
//    }
//
//    public Pane getLaneBox () {
//        VBox vBox = new VBox();
//        vBox.autosize();
//        vBox.setAlignment(Pos.CENTER);
//        vBox.setBorder(Border.stroke(Color.WHITE));
//        vBox.getChildren().addAll(getRectangle());
//        return vBox;
//    }
//
//    public Pane getVBox () {
//        VBox vBox = new VBox();
//        vBox.autosize();
//        vBox.setAlignment(Pos.CENTER);
//        vBox.setBorder(Border.stroke(Color.PLUM));
//        vBox.getChildren().addAll(getBUildingButtonBar(), getLaneBox(), getStationButtonBar());
//        return vBox;
//    }

}

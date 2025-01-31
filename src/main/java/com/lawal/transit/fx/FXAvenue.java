//package com.lawal.transit.roads;
//
//import com.lawal.transit.buildings.*;
//import com.lawal.transit.fx.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.graph.*;
//import com.lawal.transit.stations.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//
//import java.util.*;
//
//public final class FXAvenue {
//
//    private final Avenue avenue;
//    StylerizerFactory factory;
//    private final Group group;
//    private final Pane pane;
//
//    public FXAvenue (Avenue avenue) {
//        this.avenue = avenue;
//        this.factory = new StylerizerFactory();
//        this.group = new Group();
//        this.pane = new HBox();
//        this.pane.setStyle(
//            "-fx-background-color: black; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed; "
//        );
//        pane.getChildren().addAll(group);
//    }
//
//
//    public Avenue getAvenue () {
//        return avenue;
//    }
//
//    public Group getGroup () {
//        return group;
//    }
//
//    public HBox getHbox () {
//        HBox hBox = new HBox(new Group(getLeftBox()), new Group(getRightBox()));
//        hBox.setStyle(
//            "-fx-background-color: black; -fx-padding: 1; -fx-border-border-color: red; "
//        );
//        return hBox;
//    }
//
//    public HBox getSidewalkBox (Laterality laterality) {
//        HBox hBox = new HBox();
//        return
//
//    }
//
//    private HBox getLeftBox () {
//        HBox box = new HBox(getLeftBuildingButtonBar(), getLeftStationButtonBar());
//        box.setStyle("-fx-background-color: green; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed");
//        return box;
//    }
//
//    private HBox getRightBox () {
//        HBox box = new HBox(getRightBuildingButtonBar(), getRightStationButtonBar());
//        box.setStyle("-fx-background-color: green; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed");
//        return box;
//    }
//
//    private ButtonBar getLeftButtonBar () {
//        StylerizerFactory factory = new StylerizerFactory();
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<AddressEntity> buildingIterator = avenue.getLeftSideBuildings().iterator();
//        while (buildingIterator.hasNext()) {
//            FXBuildinButton fxBuilding = new FXBuildinButton(buildingIterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
//        }
//
//        Iterator<OldStationable> stationIterator = avenue.getLeftSideStations().iterator();
//        while (stationIterator.hasNext()) {
//            FXStationButton fxStation = new FXStationButton(stationIterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
//        }
//        return buttonBar;
//    }
//
//    private ButtonBar getLeftBuildingButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<AddressEntity> iterator = avenue.getLeftSideBuildings().iterator();
//        while (iterator.hasNext()) {
//            FXBuildinButton fxBuilding = new FXBuildinButton(iterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
//        }
//        return buttonBar;
//    }
//
//    private ButtonBar getLeftStationButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<OldStationable> iterator = avenue.getLeftSideStations().iterator();
//        while (iterator.hasNext()) {
//            FXStationButton fxStation = new FXStationButton(iterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
//        }
//        return buttonBar;
//    }
//
//    private ButtonBar getRightBuildingButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<AddressEntity> iterator = avenue.getRightSideBuildings().iterator();
//        while (iterator.hasNext()) {
//            FXBuildinButton fxBuilding = new FXBuildinButton(iterator.next(), factory.stylerizer(ComponentCategory.ADDRESSABLE));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxBuilding.getButton());
//        }
//        return buttonBar;
//    }
//
//    private ButtonBar getRightStationButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<OldStationable> iterator = avenue.getRightSideStations().iterator();
//        while (iterator.hasNext()) {
//            FXStationButton fxStation = new FXStationButton(iterator.next(), factory.stylerizer(ComponentCategory.VERTEX));
//            buttonBar.getButtons().add(buttonBar.getButtons().size(), fxStation.getButton());
//        }
//        return buttonBar;
//    }

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
//        Iterator<AddressEntity> iterator = lane.getBuildings().iterator();
//        while (iterator.hasNext()) {
//            buttonBar.getButtons().add(
//                buttonBar.getButtons().size(),
//                new FXBuildinButton(iterator.next(),
//                stylerizerFactory.stylerizer(ComponentCategory.ADDRESSABLE)).getButton()
//            );
//        }
//        return buttonBar;
//    }
//
//    public ButtonBar getStationButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<OldStationable> iterator = lane.getStations().iterator();
//        while (iterator.hasNext()) {
//            buttonBar.getButtons().add(
//                buttonBar.getButtons().size(),
//                new FXStationButton(iterator.next(),
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
//}
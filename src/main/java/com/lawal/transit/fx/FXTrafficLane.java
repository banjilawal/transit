package com.lawal.transit.fx;

//import com.lawal.transit.fx.interfaces.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
//
//public final class FXTrafficLane implements LaneFXWrapper {
//
//    private final Lane lane;
//    private final Rectangle rectangle;
//
//    public FXTrafficLane (Lane lane, double startX, double startY, double width, double height) {
//        this.lane = lane;
//        this.rectangle = new Rectangle(startX, startY, width, height);
//        rectangle.setFill(Color.GRAY);
//    }
//
//    @Override
//    public Lane getLane () {
//        return lane;
//    }
//
//    @Override
//    public Group getGroup () {
//        Group group = new Group();
//        if (RoadCategory.isAvenue(lane.getTrafficDirection())) {
//            HBox hBox = new HBox(rectangle);
//            hBox.setStyle(
//                "-fx-background-color: gray; " +
//                    "-fx-border-color: transparent transparent transparent white; " +
//                    "-fx-border-style: dashed none none none; " +
//                    "-fx-border-width: 0 0 0 3px; " +
//                    "-fx-border-insets: 0 0 0 0; " +
//                    "-fx-border-radius: 0; " +
//                    "-fx-border-image-slice: 1;"
//            );
//            group.getChildren().addAll(hBox);
//        }
//        else {
//            VBox vBox = new VBox(rectangle);
//            vBox.setStyle(
//                "-fx-background-color: gray;"+
//                "-fx-border-color: transparent transparent transparent white; " +
//                "-fx-border-style: none none none dashed; " +
//                "-fx-border-width: 0 0 0 3px; " +
//                "-fx-border-insets: 0 0 0 0; " +
//                "-fx-border-radius: 0; " +
//                "-fx-border-image-slice: 1;"
//            );
//            group.getChildren().addAll(vBox);
//        }
//        group.setAutoSizeChildren(true);
//        return group;
//    }

//
//    private final Lane lane;
//    private final Stylerizerable stylerizer;
//    private final Rectangle rectangle;
//    private final Group group;
//    private final Pane pane;
//
//    public FXTrafficLane (
//        Lane lane,
//        Rectangle rectangle,
//        Stylerizerable stylerizer,
//        RoadCategory roadCategory
//    ) {
//        this.lane = lane;
//        this.rectangle = rectangle;
//        this.stylerizer = stylerizer;
//        this.group = new Group();
//        this.group.getChildren().add(rectangle);
//        if (roadCategory.equals(RoadCategory.AVENUE))
//            this.pane = new HBox();
//        else this.pane = new VBox();
//        this.pane.setStyle(
//            "-fx-background-color: black; -fx-padding: 1; -fx-border-border-color: white; -fx-border-style: dashed; "
//        );
//        pane.getChildren().addAll(group);
//    }
//
//    @Override
//    public Lane getLane () {
//        return lane;
//    }
//
//    public Group getGroup () {
//        return group;
//    }
//
//    @Override
//    public Pane getPane () {
//        return pane;
//    }
//
//
//    @Override
//    public Rectangle getRectangle () {
//        return rectangle;
//    }
//
//    @Override
//    public Stylerizerable getStylerizer () {
//        return null;
//    }
//

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
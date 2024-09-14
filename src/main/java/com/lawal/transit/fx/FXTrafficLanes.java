//package com.lawal.transit.roads;
//
//import javafx.scene.*;
//import javafx.scene.layout.*;
//
//public class FXTrafficLanes {
//
//    private final Lanes lanes;
//    private double x;
//    private double y;
//    private final double width;
//    private final double height;
//    private final double namingInterval;
//
//    public FXTrafficLanes (Lanes lanes, double x, double y, double width, double height, double namingInterval) {
//        this.lanes = lanes;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.namingInterval = namingInterval;
//    }
//
//    public Lanes getLanes () {
//        return lanes;
//    }
//
//    public Group getGroup () {
//        Group group = new Group();
//        if (roadIsAvenue())
//            group.getChildren().addAll(getVBox());
//        else
//            group.getChildren().addAll(getVBox());
//        return group;
//    }
//
//    private VBox getVBox () {
//        VBox vBox = new VBox();
//        while(lanes.iterator().hasNext()) {
//            FXTrafficLane fxTrafficLane = new FXTrafficLane(lanes.iterator().next(), x, y, width, height);
//            vBox.getChildren().addAll(fxTrafficLane.getGroup());
//            x += namingInterval;
//            y += namingInterval;
//        }
//        vBox.setStyle(cssStyling());
//        return vBox;
//    }
//
//    private HBox getHBox () {
//        HBox hBox = new HBox();
//        while(lanes.iterator().hasNext()) {
//            FXTrafficLane fxTrafficLane = new FXTrafficLane(lanes.iterator().next(), x, y, width, height);
//            hBox.getChildren().addAll(fxTrafficLane.getGroup());
//            x += namingInterval;
//            y += namingInterval;
//        }
//        hBox.setStyle(cssStyling());
//        return hBox;
//    }
//
//    private boolean roadIsAvenue () {
//        return lanes.getTrafficDirection().equals(Avenue.RIGHTWARD_TRAFFIC_DIRECTION) ||
//            lanes.getTrafficDirection().equals(Avenue.RIGHTWARD_TRAFFIC_DIRECTION);
//    }
//
//    private String cssStyling () {
//        return "-fx-background-color: gray;";
//    }
//}
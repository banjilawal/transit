//package com.lawal.transit.fx;
//
//import com.lawal.transit.fx.interfaces.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.roads.interfaces.*;
//import javafx.scene.layout.*;
//import javafx.scene.shape.*;
//
//public class TrafficLaneFX implements LaneFXWrapper {
//
//    private final Lane trafficLane;
//    private final Rectangle rectangle;
//
//    public TrafficLaneFX (Lane trafficLane, Rectangle rectangle) {
//        this.trafficLane = trafficLane;
//        this.rectangle = rectangle;
//    }
//
//    @Override
//    public Lane getLane () {
//        return trafficLane;
//    }
//
//    @Override
//    public HBox hBox () {
//        HBox hBox = new HBox(rectangle);
//        hBox.setStyle(Styling.LANE_HBOX_CSS);;
//        return hBox;
//    }
//
//    @Override
//    public VBox vBox () {
//        VBox vBox = new VBox(rectangle);
//        vBox.setStyle(Styling.LANE_VBOX_CSS);
//        return vBox;
//    }
//
//    @Override
//    public Rectangle getRectangle () {
//        return rectangle;
//    }
//}
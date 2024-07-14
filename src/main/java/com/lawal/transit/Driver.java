package com.lawal.transit;

import com.lawal.transit.buildings.*;
import com.lawal.transit.fx.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.road.*;
import com.lawal.transit.road.interfaces.*;
import com.lawal.transit.stations.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class Driver extends Application {

    public static Color BUILDING_COLOR = Color.LIGHTBLUE;
    public static int DEFAULT_SPACING = 15;
    public static int DEFAULT_LIST_SIZE = 3;
    public static double LANE_WIDTH = 400;
    public static double LANE_HEIGHT = 20;
    public static double X_COORDINATE = 50;
    public static double Y_COORDINATE = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Transit Component Testing");

        StylerInterface styler = new Styler();
        RoadSideCategory roadSideCategory = RoadSideCategory.RIGHT_SIDE;
        Avenue avenue = new Avenue("1st", 1, 1, 1);

        ButtonBar buildingButtons = new ButtonBar();
        for (int index = 0; index < 5; index++) {
            String name = avenue.getIdentifier().getId() * 1000 + index + "";
            FormattedAddress address = new Address(index, name, avenue, roadSideCategory);
            Addressable building = new Building(address);
            FXAddressableControl fxBuilding = new FXBuilding(building, styler);
            buildingButtons.getButtons().add(buildingButtons.getButtons().size(), fxBuilding.getButton());
        }

        ButtonBar stationButtons = new ButtonBar();
        for (int index = 0; index < 5; index++) {
            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
            FormattedAddress address = new Address(index, name, avenue, roadSideCategory);
            Vertex station = new Station(address);
            FXVertexControl fxStation = new FXStation(station, styler);
            stationButtons.getButtons().add(stationButtons.getButtons().size(), fxStation.getButton());
        }

        StylerInterface laneStyler = new Styler(
            "-fx-fill: lightgrey; -fx-scale-shape: true; -fx-width: 2500; -fx-height: 45; -fx-background-color: transparent; ",
            "-fx-padding: 300; ",
            "-fx-border-style: dashed; -fx-stroke-dash-corner: none; -fx-border-width: 105; -fx-border-color: red; -fx-border-insets: 20; border-"
        );
        //System.out.println(laneStyler.toString());
        Lane lane = new TrafficLane(Avenue.RIGHT_LANE_TRAFFIC_DIRECTION, 0);
        ShapeableLane fxLane = new FXTrafficLane(lane, 1200, 2, 0,0, laneStyler);
        System.out.println(fxLane.getStyler());

        VBox vBox = new VBox(50);
        vBox.getChildren().addAll(buildingButtons, stationButtons, fxLane.getShape());
        vBox.setStyle("-fx-background-color: green;");

        Scene scene = new Scene(vBox, 300, 250);
        scene.setFill(Color.GREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

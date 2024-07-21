package com.lawal.transit;

import com.lawal.transit.fx.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;

import com.lawal.transit.ui.*;
import com.lawal.transit.buildings.*;
import com.lawal.transit.road.*;
import com.lawal.transit.stations.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    public static Color BUILDING_COLOR = Color.LIGHTBLUE;
    public static int DEFAULT_SPACING = 15;
    public static int DEFAULT_LIST_SIZE = 3;
    public static double ROAD_LENGTH = 400;
    public static double ROAD_WIDTH = 20;
    public static double X_COORDINATE = 50;
    public static double Y_COORDINATE = 100;

    @Override
    public void start (Stage stage) throws Exception {

    }

    //    public static void main(String[] args) {
//        launch(args);
//    }
}



//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Hello World!");
//
//        Lane lane = new TrafficLane(Orientation.NORTH, new Buildings(), new Stations());
//        RoadIdentifiable roadIdentity = new RoadIdentifier(1, "Askia");
//        double startX = X_COORDINATE;
//        double startY = Y_COORDINATE;
//        double endX = startX + ROAD_LENGTH;
//        double endY = startY + ROAD_WIDTH;
//        Avenue avenue = new Avenue(roadIdentity, new TrafficLanes(), startX, startY, endX, endY);
//        avenue.getLanes().add(new LaneBuilder(Orientation.NORTH).cre);
//        avenue.getLanes().add(new TrafficLane(Orientation.SOUTH, new Buildings(), new Stations()));
//
//        TrafficLane lane = new TrafficLane(Orientation.NORTH, new Buildings(), new Stations());
//        lane.setWidth(10);
//        lane.setFill(Color.GRAY);
//        avenue.getLanes().add(lane);
//        avenue.getLanes().add(new TrafficLane(Orientation.SOUTH, new Buildings(), new Stations()));
//
//        FormattedAddress address = new Address(1, "2000", avenue.getIdentifier(), Orientation.SOUTH);
//        Addressable building = new Building(address);
//        FXAddressableControl fxBuilding = new FXBuilding(building, 50, 50, 100, 40, BUILDING_COLOR);
//
//
//        address = new Address(5,"MT501", avenue.getIdentifier(), Orientation.SOUTH);
//        Vertex station = new Station(address,new Edges(), new Edges());
//        avenue.getLanes().getLeftmostLane().getStations().add(station);
//        avenue.getLanes().getLeftmostLane().getAddresses().add(fxBuilding.getAddressable());
//        ShapedVertex shapedStation = new ShapedVertex(station, 400, 400, 80);
////        Polygon triangle = decorated.createTriangle(300,300);
//
//
//
//        Button btn = new Button();
//        Button btn2 = new Button();
//        btn.setText("Say 'Hello World'");
//        btn2.setText("Click me");
//
////        Line line = new Line();
////        line.setStartX(50);
////        line.setStartY(50);
//
////        line.setEndX(300);
////        line.setEndY(300);
////        line.setStroke(Color.BLACK);
////        line.setStrokeWidth(20);
//
//        Line line = new Line(50, 50, 300, 50);
//        line.setStroke(Color.BLUE);
//        line.setStrokeWidth(20);
//
//        Circle circle = new Circle(150, 150, 50, Color.RED);
//
//        Rectangle rectangle = new Rectangle(200, 200, 100, 50);
//        rectangle.setFill(Color.RED);
//
//        Label label = new Label("This is a label");
//        label.setLayoutX(50);
//        label.setLayoutY(300);
//
////        RoadFactory avenueFactory = new RoadFactory();
////        Avenue avenue = (Avenue) avenueFactory.createRoad(new RoadIdentifier(1, "Granville"), new TrafficLanes(), 50, 100, 450, 100);
////        avenue.setStroke(Color.BLACK);
////        avenue.setStrokeWidth(20);
////        avenue.addLabel();
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//
//        btn2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println(avenue.toString());
//            }
//        });
//        Pane pane = new Pane();
//        pane.getChildren().addAll(shapedBuilding.shape(), shapedStation.shape()); //avenue, btn);
//        pane.setStyle("-fx-background-color: green;");
//
//        Scene scene = new Scene(pane, 300, 250);
//        scene.setFill(Color.GREEN);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

//    public static void main(String[] args) {
//        launch(args);
//    }

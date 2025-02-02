//package com.lawal.transit;
//
//import com.lawal.transit.creation.*;
//import com.lawal.transit.fx.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.roads.*;
//import javafx.application.*;
//import javafx.scene.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.*;
//import javafx.scene.shape.*;
//import javafx.stage.*;
//
//public class Driver2 extends Application {
//
//    public static double SCENE_WIDTH = 800;
//    public static double SCENE_HEIGHT = 380;
//    public static Color BUILDING_COLOR = Color.LIGHTBLUE;
//    public static Color STATION_COLOR = Color.WHITE;
//    public static Color TRAFFIC_LANE_COLOR = Color.GRAY;
//    public static Color SCENE_COLOR = Color.GREEN;
//
//    public static int NUMBER_OF_BUILDINGS = 25;
//    public static int NUMBER_OF_STATIONS = 18;
//
//    public static int DEFAULT_SPACING = 15;
//    public static int DEFAULT_LIST_SIZE = 3;
//    public static double LANE_WIDTH = 400;
//    public static double LANE_HEIGHT = 10;
//    public static double X_COORDINATE = 0;
//    public static double Y_COORDINATE = 100;
//    public static double RESIZING_DIVISION_FACTOR = 2;
//    public static double RESIZING_SUBTRACTION_FACTOR = 5;
//
//    public static int buildingId = 1;
//    public static int stationId = 1;
//    @Override
//    public void start (Stage primaryStage) throws Exception {
//        AvenueBuilder builder = new AvenueBuilder();
//        builder.setAvenueName("Alpha");
//        builder.setAvenueId(1);
//        builder.setStartingBuildingId(1);
//        builder.setStartingStationId(1);
//        builder.buildingsPerFrontage(20);
//        builder.stationsPerFrontage(5);
//        Avenue avenueA = builder.build();
//        System.out.println(avenueA.toString());
//        System.out.println(avenueA.rightFrontage().toString());
//        System.out.println(avenueA.leftFrontage().toString());
//
//        builder.setAvenueName("Beta");
//        builder.setAvenueId(2);
//        builder.setStartingStationId(builder.nextStationId());
//        builder.setStartingBuildingId(builder.nextBuildingId());
//        builder.buildingsPerFrontage(15);
//        builder.stationsPerFrontage(8);
//        Avenue avenueB = builder.build();
//        System.out.println(avenueB.toString());
//        System.out.println(avenueB.rightFrontage().toString());
//        System.out.println(avenueB.leftFrontage().toString());
//
//        System.out.println(avenueA.leftLanes().getLane(0).toString());
//
//        Rectangle rectangle = new Rectangle(0, 105, SCENE_WIDTH, 10);
//        rectangle.setStyle(Styling.RECTANGLE_CSS);
//
//            "-fx-fill: gray;"
//            + " -fx-margin: 2px;");//setFill(Color.BLACK);
//        VBox laneAVBox = new VBox(rectangle);
//        laneAVBox.setStyle(Styling.LANE_VBOX_CSS); //"-fx-background-color: black;"
//           + " -fx-border-color: white transparent transparent transparent;"
//           + " -fx-border-style: dashed solid solid solid;"
//           + " -fx-border-width: 3 0 0 0;"
//           + " -fx-padding: 8px;");
//        laneVBox.getStyleClass().add(
//            "-fx-border-width: 2 0 0 0;"
//            + " -fx-border-color: white transparent transparent transparent;"
//            + " -fx-border-style: dashed solid solid solid"
//        );
//        FrontageFX lFFXa = new FrontageFX(avenueA.getLeftFrontage());
//        LaneFXWrapper lLFXa = new TrafficLaneFX(avenueA.getLeftCarriageway().getLane(0), rectangle);
//
//        FrontageFX rFFXa = new FrontageFX(avenueA.getRightFrontage());
//        LaneFXWrapper rLFXa = new TrafficLaneFX(avenueA.getRightCarriageway().getLane(0), rectangle);
//        VBox containerA = new VBox ();
//
//        FrontageFX lFFXb = new FrontageFX(avenueB.getLeftFrontage());
//        LaneFXWrapper lLFXb = new TrafficLaneFX(avenueB.getLeftCarriageway().getLane(0), rectangle);
//
//        FrontageFX rFFXb = new FrontageFX(avenueB.getRightFrontage());
//        LaneFXWrapper rLFXb = new TrafficLaneFX(avenueB.getRightCarriageway().getLane(0), rectangle);
//        VBox containerB = new VBox ();
//        containerB.getChildren().addAll(lFFXb.vBox(), lLFXb.hBox(), rLFXb.vBox(), rFFXb.vBox());
//        containerA.getChildren().addAll(lFFXa.vBox(), lLFXa.hBox(), rLFXa.vBox(), rFFXa.vBox());
//
//        ShapeDetails details = new ShapeDetails(0, 105, SCENE_WIDTH, 10, Color.BLACK);
//        AvenueFX avenueAFX = new AvenueFX(avenueA, details, 3);
//
//        VBox grid = new VBox();
//        grid.getChildren().addAll(avenueAFX.getVbox());
//        //Group group = new Group();
//       // group.getChildren().addAll(container);
//        Scene scene = new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT, SCENE_COLOR);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

//.vbox {
//        -fx-background-color: orange;
//        -fx-border-color: green;
//        -fx-border-style: dashed;
//        -fx-border-width: 2px;
//        -fx-padding: 10px; /* Adds padding inside the VBox for the Rectangle */
//    }

//.rectangle {
//-fx-fill: grey;
//-fx-margin: 10px; /* Adds margin around the Rectangle inside the VBox */
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Transit Component Testing");

//        StylerizerableFactorable stylerizer = new StylerizerFactory();
//        Laterality roadLateral = Laterality.RIGHT;
//        Avenue avenue = new Avenue(1, "1st");
//
//        BorderLane lane = (BorderLane) avenue.getRightLanes().getBorderLane();
//        FXTrafficLane fxLane = new FXTrafficLane(
//            lane,
//            stylerizer.stylerizer(ComponentCategory.LANE),
//            X_COORDINATE,
//            Y_COORDINATE,
//            SCENE_WIDTH,
//            LANE_HEIGHT
//        );
//        ShapeableLane fxLane = new FXTrafficLane(
//            lane, stylerizer.stylerizer(ComponentCategory.LANE),
//            new RectangleDimension(new Coordinate(X_COORDINATE, Y_COORDINATE), LANE_WIDTH, LANE_HEIGHT)
//        );

//        ButtonBar buildingButtons = initButtonBar();
//        for (int index = 0; index < NUMBER_OF_BUILDINGS; index++) {
//            AddressEntity building = createBuilding(avenue, roadLateral, index);
//            lane.getBuildings().add((createBuilding(avenue, roadLateral, index));
//            AddressableFXControlable fxBuilding = createFXBuilding(building, stylerizer.stylerizer(ComponentCategory.ADDRESSABLE));
//            buildingButtons.getButtons().add(buildingButtons.getButtons().size(), fxBuilding.getButton());
//        }

//        ButtonBar stationButtons = initButtonBar();
//        for (int index = 0; index < NUMBER_OF_STATIONS; index++) {
//            lane.getStations().add(createStation(avenue, roadLateral, index));
//            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
//            FormattedAddress address = new RetiredAddressOld(index, name, avenue, roadLateral);
//            OldStationable station = new Station(address);
//            VertexFXControllable fxStation = new FXStationButton(station, stylerizer.stylerizer(ComponentCategory.VERTEX));
//            stationButtons.getButtons().add(stationButtons.getButtons().size(), fxStation.getButton());
//        }
//
//        Laneable lane = new Lane(Avenue.RIGHT_LANE_TRAFFIC_DIRECTION, 0);
//
//        System.out.println(fxLane.getStyler());

//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(buildingButtons, fxLane.getShape(), stationButtons);
//        vBox.setAlignment(Pos.CENTER);
//        vBox.spacingProperty().set(5);
//        vBox.autosize();

//
//        Group group = new Group();
//        group.getChildren().addAll(fxLane.getRectangle());
//        group.getChildren().addAll(new FXTrafficLane(lane, stylerizer.stylerizer(ComponentCategory.LANE), X_COORDINATE, Y_COORDINATE, LANE_WIDTH, LANE_HEIGHT).getVBox());
//        group.autoSizeChildrenProperty().set(true);

//        Group group = new Group();
//        Scene scene = new Scene(group);
//        primaryStage.setScene(scene);
//        scene.setFill(Color.GREEN);
//        primaryStage.show();
//    }
//
//
//}
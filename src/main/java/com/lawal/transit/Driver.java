//package com.lawal.transit;
//
//import com.lawal.transit.buildings.*;
//import javafx.application.*;
//import javafx.scene.paint.*;
//import javafx.stage.*;
//
//import static javafx.application.Application.launch;
//
//public class Driver extends Application {
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

//    public static ButtonBar initButtonBar () {
//        ButtonBar buttonBar = new ButtonBar();
//        buttonBar.prefWidthProperty().bind(
//            buttonBar.widthProperty().divide(RESIZING_DIVISION_FACTOR).subtract(RESIZING_DIVISION_FACTOR)
//        );
//        return buttonBar;
//    }
//
//    public static AddressEntity createBuilding (Road roads, Laterality laterality, int number) {
//        String name = roads.getIdentifier().getId() * 1000 + number + "";
//        return new Place(new RetiredAddressOld(number, name, roads, laterality));
//    }

//
//    public static AddressableFXControlable createFXBuilding (AddressEntity addressable, Stylerizerable stylerizerable) {
//        return new FXBuildinButton(addressable, stylerizerable);
//    }
//
//    public static VertexFXControllable createFXStation (OldStationable vertex, Stylerizerable stylerizerable) {
//        return new FXStationButton(vertex, stylerizerable);
//    }
//
//

//    public static ShapeableLane createFXLane (Lane lane, RectangleDimension dimension, Stylerizerable stylerizerable) {
//        return new FXTrafficLane(lane, stylerizerable,dimension);
//    }
//
//    public void printBuildings (Iterator<AddressEntity> iterator) {
//        while(iterator.hasNext()) {
//            AddressEntity building = iterator.next();
//            System.out.println(building.getAddress().getId() + " " + building.toString());
//        }
//    }
//
//    public void printStations (Iterator<OldStationable> iterator) {
//        while(iterator.hasNext()) {
//            OldStationable station = iterator.next();
//            System.out.println(station.getAddress().getId() + " " + station.toString());
//        }
//    }
//
//    public static VBox getAvenueVBox (Avenue avenue, StylerizerableFactorable f) throws Exception {
//        ButtonBar rightStationButtons = initButtonBar();
//        for (int index = 0; index <= 10; index +=2) {
//            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
//            FormattedAddress address = new RetiredAddressOld(stationId, name, avenue, Laterality.RIGHT);
//            OldStationable station = new Station(address);
//
//            avenue.getRightSideStations().add(station);
//            System.out.println("Added " + station.toString());
//            VertexFXControllable fxStation = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            rightStationButtons.getButtons().addAll(fxStation.getButton());
//            stationId++;
//        }
//
//        ButtonBar rightBuildingButtons = initButtonBar();
//        for (int index = 0; index < 20; index +=2) {
//            String name = avenue.getIdentifier().getId() * 1000 + index + "";
//            AddressEntity building = new Place(new RetiredAddressOld(buildingId, name, avenue, Laterality.RIGHT));
//            avenue.getRightSideBuildings().add(building);
//            AddressableFXControlable fxBuilding = createFXBuilding(building, f.stylerizer(ComponentCategory.ADDRESSABLE));
//            rightBuildingButtons.getButtons().addAll(fxBuilding.getButton());
//            buildingId++;
//        }
//
//        ButtonBar leftStationButtons = initButtonBar();
//        for (int index = 1; index <= 7; index +=2) {
//            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
//            FormattedAddress address = new RetiredAddressOld(stationId, name, avenue, Laterality.LEFT);
//            OldStationable station = new Station(address);
//
//            avenue.getLeftSideStations().add(station);
//            System.out.println("Added " + station.toString());
//            VertexFXControllable fxStation = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            leftStationButtons.getButtons().addAll(fxStation.getButton());
//            stationId++;
//        }
//
//        ButtonBar leftBuildingButtons = initButtonBar();
//        for (int index = 1; index < 25; index +=2) {
//            String name = avenue.getIdentifier().getId() * 1000 + index + "";
//            AddressEntity building = new Place(new RetiredAddressOld(buildingId, name, avenue, Laterality.LEFT));
//            avenue.getLeftSideBuildings().add(building);
//            AddressableFXControlable fxBuilding = createFXBuilding(building, f.stylerizer(ComponentCategory.ADDRESSABLE));
//            leftBuildingButtons.getButtons().addAll(fxBuilding.getButton());
//            buildingId++;
//        }
//
//        ButtonBar leftStationButtons = initButtonBar();
//        sIterator = avenue.getRightSideStations().iterator();
//        while(sIterator.hasNext()) {
//            OldStationable station = sIterator.next();
//            System.out.println(station.toString());
//            FXStationButton control = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            System.out.println("made a left station control");
//            leftStationButtons.getButtons().addAll(control.getButton());
//        }
//
//        VBox rightBox = new VBox();
//        rightBox.getChildren().addAll(rightBuildingButtons, rightStationButtons);
//        rightBox.setStyle(f.stylerizer(ComponentCategory.LANE).toString());
//
//        VBox leftBox = new VBox();
//        leftBox.getChildren().addAll(leftBuildingButtons, leftStationButtons);
//        leftBox.setStyle(f.stylerizer(ComponentCategory.LANE).toString());
//
//        VBox avenueBox = new VBox();
//        avenueBox.getChildren().addAll(leftBox, rightBox);
//        avenueBox.setBorder(Border.stroke(Color.ORANGE));
//
//        return avenueBox;
//    }
//
//    @Override
//    public void start (Stage primaryStage) throws Exception {
//        AvenueBuilder avenueBuilder = new AvenueBuilder("Alpha", 1,0, 0, 9, 120);
//        Avenue avenue = new AvenueBuilder("Alpha", 1,0, 0).build(); //, 0, 9, 12).build();
//        AvenueFX avenueFXPane = new AvenueFX(avenue, new ShapeDetails(0, 85, SCENE_WIDTH, 15, Color.GRAY), 3);
//        HBox hBox = avenueFXPane.getLeftPane();
//        System.out.println(avenue.toString());
//        System.out.println(avenueFXPane.getAvenue().toString());
//        StylerizerableFactorable f = new StylerizerFactory();
//        Group group = new Group();

//        Avenue avenue = avenueBuilder.build();
//        Avenue avenue = new Avenue(1, "Alpha");
//        VBox box1 = getAvenueVBox(avenue, f);
//
//        avenue = new Avenue(2, "Beta");
//        VBox box2 = getAvenueVBox(avenue,f);
//
//        VBox cityBox = new VBox();
//        cityBox.getChildren().addAll(box1, box2);

//
//        int stationId = 1;
//        ButtonBar rightStationButtons = initButtonBar();
//        for (int index = 0; index <= 10; index +=2) {
//            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
//            FormattedAddress address = new RetiredAddressOld(stationId, name, avenue, Laterality.RIGHT);
//            OldStationable station = new Station(address);
//
//            avenue.getRightSideStations().add(station);
//            System.out.println("Added " + station.toString());
//            VertexFXControllable fxStation = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            rightStationButtons.getButtons().addAll(fxStation.getButton());
//            stationId++;
//        }
//
//        int buildingId = 1;
//        ButtonBar rightBuildingButtons = initButtonBar();
//        for (int index = 0; index < 20; index +=2) {
//            String name = avenue.getIdentifier().getId() * 1000 + index + "";
//            AddressEntity building = new Place(new RetiredAddressOld(buildingId, name, avenue, Laterality.RIGHT));
//            avenue.getRightSideBuildings().add(building);
//            AddressableFXControlable fxBuilding = createFXBuilding(building, f.stylerizer(ComponentCategory.ADDRESSABLE));
//            rightBuildingButtons.getButtons().addAll(fxBuilding.getButton());
//            buildingId++;
//        }
//
//        ButtonBar leftStationButtons = initButtonBar();
//        for (int index = 1; index <= 7; index +=2) {
//            String name = "MT-" + avenue.getIdentifier().getId() * 1000 + index;
//            FormattedAddress address = new RetiredAddressOld(stationId, name, avenue, Laterality.LEFT);
//            OldStationable station = new Station(address);
//
//            avenue.getLeftSideStations().add(station);
//            System.out.println("Added " + station.toString());
//            VertexFXControllable fxStation = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            leftStationButtons.getButtons().addAll(fxStation.getButton());
//            stationId++;
//        }
//
//        ButtonBar leftBuildingButtons = initButtonBar();
//        for (int index = 1; index < 25; index +=2) {
//            String name = avenue.getIdentifier().getId() * 1000 + index + "";
//            AddressEntity building = new Place(new RetiredAddressOld(buildingId, name, avenue, Laterality.LEFT));
//            avenue.getLeftSideBuildings().add(building);
//            AddressableFXControlable fxBuilding = createFXBuilding(building, f.stylerizer(ComponentCategory.ADDRESSABLE));
//            leftBuildingButtons.getButtons().addAll(fxBuilding.getButton());
//            buildingId++;
//        }
//
//        ButtonBar leftStationButtons = initButtonBar();
//        sIterator = avenue.getRightSideStations().iterator();
//        while(sIterator.hasNext()) {
//            OldStationable station = sIterator.next();
//            System.out.println(station.toString());
//            FXStationButton control = new FXStationButton(station, f.stylerizer(ComponentCategory.VERTEX));
//            System.out.println("made a left station control");
//            leftStationButtons.getButtons().addAll(control.getButton());
//        }

//        VBox rightBox = new VBox();
//        rightBox.getChildren().addAll(rightBuildingButtons, rightStationButtons);
//        rightBox.setStyle(f.stylerizer(ComponentCategory.LANE).toString());
//
//        VBox leftBox = new VBox();
//        leftBox.getChildren().addAll(leftBuildingButtons, leftStationButtons);
//        leftBox.setStyle(f.stylerizer(ComponentCategory.LANE).toString());
//
//        VBox avenueBox = new VBox();
//        avenueBox.getChildren().addAll(leftBox, rightBox);
//        avenueBox.setBorder(Border.stroke(Color.ORANGE));

//        Scene scene = new Scene(cityBox);
//        scene.setFill(Color.PLUM);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();

//        System.out.println(avenue.toString() + "\n");
//        Iterator<AddressEntity> buildingIterator = avenue.getLeftSideBuildings().iterator();
//        while(buildingIterator.hasNext()) {
//            AddressEntity building = buildingIterator.next();
//            System.out.println(building.getAddress().getId() + " " + building.toString());
//        }
//        buildingIterator = avenue.getRightSideBuildings().iterator();
//        while(buildingIterator.hasNext()) {
//            AddressEntity building = buildingIterator.next();
//            System.out.println(building.getAddress().getId() + " " + building.toString());
//        }
//        Iterator<OldStationable> stationIterator = avenue.getLeftSideStations().iterator();
//        while(stationIterator.hasNext()) {
//            OldStationable station = stationIterator.next();
//            System.out.println(station.getAddress().getId() + " " + station.toString());
//        }
//        stationIterator = avenue.getRightSideStations().iterator();
//        while(stationIterator.hasNext()) {
//            OldStationable station = stationIterator.next();
//            System.out.println(station.getAddress().getId() + " " + station.toString());
//        }
//        FXAvenue fxAvenue = new FXAvenue(avenue);
//
//
//        StreetBuilder streetBuilder = new StreetBuilder(1, 3,3, avenueBuilder.getCurrentBuildingId(), avenueBuilder.getCurrentStationId());
//        Street street = streetBuilder.build();
//        System.out.println(street.toString() + "\n");
//        printBuildings(street.getLeftSideBuildings().iterator());
//        printBuildings(street.getRightSideBuildings().iterator());
//        printStations(street.getLeftSideStations().iterator());
//        printStations(street.getRightSideStations().iterator());
//        VBox vBox = fxAvenue.getVbox();
//
//        VBox papa = new VBox(vBox);
//        papa.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        papa.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        VBox.setVgrow(vBox, Priority.ALWAYS);
//
//
//
//        Scene scene = new Scene(papa, SCENE_WIDTH, SCENE_HEIGHT);
//        scene.setFill(SCENE_COLOR);
//        primaryStage.setScene(scene);
//        primaryStage.show();


//        Rectangle rectangle = new Rectangle(X_COORDINATE, Y_COORDINATE, SCENE_WIDTH, LANE_HEIGHT);
//        rectangle.setFill(TRAFFIC_LANE_COLOR);
//        StylerizerableFactorable stylerizer = new StylerizerFactory();
//        Avenue avenue = new Avenue(1, "1st");
//        FXTrafficLane fxLane = new FXTrafficLane(
//            avenue.getLeftLanes().getLane(0),
//            rectangle,
//            stylerizer.stylerizer(ComponentCategory.LANE),
//            avenue.getIdentifier().getCategory()
//        );
//       Scene scene = new Scene(hBox, SCENE_WIDTH, SCENE_HEIGHT, SCENE_COLOR);
//        fxLane.getRectangle().widthProperty().bind(scene.widthProperty().multiply(0.5));
//        fxLane.getRectangle().heightProperty().bind(scene.heightProperty().multiply(0.5));//       primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//

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
//        Lane lane = new TrafficLane(Avenue.RIGHT_LANE_TRAFFIC_DIRECTION, 0);
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
//      group.getChildren().addAll(new FXTrafficLane(lane, stylerizer.stylerizer(ComponentCategory.LANE), X_COORDINATE, Y_COORDINATE, LANE_WIDTH, LANE_HEIGHT).getVBox());
//        group.autoSizeChildrenProperty().set(true);

//        Group group = new Group();
//        Scene scene = new Scene(group);
//        primaryStage.setScene(scene);
//        scene.setFill(Color.GREEN);
//        primaryStage.show();
//    }
//}
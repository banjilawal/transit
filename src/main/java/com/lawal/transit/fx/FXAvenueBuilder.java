//package com.lawal.transit.fx;
//
//import com.lawal.transit.globals.*;
//import com.lawal.transit.roads.*;
//import javafx.scene.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.*;
//
//
//public class FXAvenueBuilder {
//
//    private final Avenue avenue;
//    private final double startingX;
//    private final double startingY;
//    private final double width;
//    private final double height;
//    private final double namingInterval;
//
//
//    public FXAvenueBuilder (Avenue avenue, double startingX, double startingY, double width, double height, double namingInterval) {
//        this.avenue = avenue;
//        this.startingX = startingX;
//        this.startingY = startingY;
//        this.width = width;
//        this.height = height;
//        this.namingInterval = namingInterval;
//    }
//
//    public Avenue getAvenue () {
//        return avenue;
//    }
//
//    private Group getFrontageGroup (Laterality laterality) {
//        if (laterality.equals(Laterality.LEFT))
//            return new FrontageFX(avenue.leftCurb()).getGroup();
//        else
//            return new FrontageFX(avenue.rightCurb()).getGroup();
//    }
//
//    private HBox getFXTrafficLanes (Laterality laterality) {
//        ShapeDetails details = new ShapeDetails(startingX, startingY, width, height, Color.GRAY);
//        if (laterality.equals(Laterality.LEFT))
//            return new CarriagewayFX(avenue.leftCarriageway(), details, 2).getHBox();//FXTrafficLanes(avenue.getLeftCarriageway(), startingX, startingY, width, height, namingInterval).getGroup();
//        else
//            return new CarriagewayFX(avenue.rightCarriageway(), details, namingInterval).getHBox();
//    }
//
//    public VBox getVBox () {
//        VBox vBox = new VBox(getFrontageGroup(Laterality.LEFT), getFXTrafficLanes(Laterality.LEFT));
//        vBox.getChildren().addAll(getFrontageGroup(Laterality.RIGHT), getFXTrafficLanes(Laterality.RIGHT));
//        return vBox;
//    }

//    private VBox getSidewalkVBox (Laterality laterality) {
//        VBox sidewalkVBox = new VBox();
//        return sidewalkVBox;
//    }
//
//    private ButtonBar getStationButtonBar (Laterality roadLateral) {
//        ButtonBar buttonBar = new ButtonBar();
//        Stationables stations = avenue.getLeftSideStations();
//        if (roadLateral.equals(Laterality.RIGHT))
//            stations = avenue.getRightSideStations();
//        Iterator<OldStationable> iterator = stations.iterator();
//        while (iterator.hasNext()) {
//            VertexFXControllable controlable = new FXStationButton(
//                iterator.next(),
//                stylerizerFactory.stylerizer(ComponentCategory.VERTEX)
//            );
//            buttonBar.getButtons().addAll(controlable.getButton());
//        }
//        return buttonBar;
//    }
//
//    private ButtonBar getBuildingButtonBar (Laterality roadLateral) {
//        ButtonBar buttonBar = new ButtonBar();
//        Addressables buildings = avenue.getLeftSideBuildings();
//        if (roadLateral.equals(Laterality.RIGHT))
//            buildings = avenue.getRightSideBuildings();
//        Iterator<AddressEntity> iterator = buildings.iterator();
//        while (iterator.hasNext()) {
//            AddressableFXControlable controllable = new FXBuildinButton(
//                iterator.next(),
//                stylerizerFactory.stylerizer(ComponentCategory.ADDRESSABLE)
//            );
//            buttonBar.getButtons().addAll(controllable.getButton());
//        }
//        return buttonBar;
//    }


//    private Rectangle getRoadShape () {
//
//    }
//}
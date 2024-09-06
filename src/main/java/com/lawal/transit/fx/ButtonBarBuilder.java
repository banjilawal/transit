//package com.lawal.transit.fx;
//
//import com.lawal.transit.places.*;
//import com.lawal.transit.fx.interfaces.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.graph.*;
//import com.lawal.transit.stations.interfaces.*;
//import javafx.scene.control.*;
//
//import java.util.*;
//
//public class ButtonBarBuilder {
//
//    public ButtonBarBuilder () {}
//
//    public ButtonBar build (Stationables vertices) {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<OldStationable> iterator = vertices.iterator();
//        while (iterator.hasNext()) {
//            OldStationable stationable = iterator.next();
//            VertexFXControllable control = new FXStationButton(stationable);
//            buttonBar.getButtons().addAll(new ButtonBuilder().build(stationable));
//        }
//        buttonBar.setStyle(Styling.STATION_BUTTON_BAR_CSS);
//        return buttonBar;
//    }
//
//    public ButtonBar build (Addressables addressables) {
//        ButtonBar buttonBar = new ButtonBar();
//        Iterator<Addressable> iterator = addressables.iterator();
//        while (iterator.hasNext()) {
//            Addressable addressable = iterator.next();
//            buttonBar.getButtons().addAll(new ButtonBuilder().build(addressable));
//        }
//        buttonBar.setStyle(Styling.BUILDING_BUTTON_BAR_CSS);
//        return buttonBar;
//    }
//}
//package com.lawal.transit.fx;
//
//import com.lawal.transit.places.*;
//import com.lawal.transit.globals.*;
//import com.lawal.transit.graph.*;
//import com.lawal.transit.addressing.*;
//import javafx.scene.control.*;
//
//public class ButtonBuilder {
//
//    public ButtonBuilder () {}
//
//    public Button build (Addressable addressable) {
//        FormattedAddress address = addressable.address();
//        String title = address.name() + "\n"
//            + address.roadIdentity().name()
//            + " " + address.orientation().abbreviation();
//        System.out.println("button title:" + title);
//        Button button = new Button(title);
//        button.setStyle(Styling.BUILDING_BUTTON_CSS);
//        button.setTooltip(new Tooltip(addressable.toString()));
//        return button;
//    }
//
//    public Button build (OldStationable stationable) {
//        FormattedAddress address = stationable.getAddress();
//        String toolTipText = address.roadIdentity().name() + " " + address.orientation().abbreviation();
//        Button button = new Button(address.name());
//        button.setStyle(Styling.ROUND_BUTTON_CSS);
//        button.setTooltip(new Tooltip(toolTipText));
//        return button;
//    }
//}
package com.lawal.transit.fx;

import com.lawal.transit.roads.interfaces.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public final class FrontageFX {

    private final RoadSectional frontage;
    private final ButtonBar stationsButtonBar;
    private final HBox outerHBox;
    private final VBox outerVBox;
    private HBox innerHBox;
    private VBox innerVBox;

    public FrontageFX (RoadSectional frontage) {
        this.frontage = frontage;
        this.outerHBox = new HBox();
        this.outerVBox = new VBox();
        this.innerHBox = new HBox();
        this.innerVBox = new VBox();
        this.stationsButtonBar = new ButtonBarBuilder().build(frontage.stations());
    }

    public RoadSectional getFrontage () {
        return frontage;
    }

//    public VBox vBox () {
//        int blockIndex = 0;
//        VBox outerBox = new VBox();
//        Iterator<Addressables> blockIterator = frontage.blocks().iterator();
//        while (blockIterator.hasNext()) {
//            HBox innerBox = new HBox();
//            Addressables block = blockIterator.next();
//            innerBox.getChildren().addAll(new ButtonBarBuilder().build(block));
//            Iterator<OldStationable> stationIterator = frontage.stations().iterator();
//            while (stationIterator.hasNext()) {
//                OldStationable station = stationIterator.next();
//                if (station.getAddress().getBlockId() == blockIndex) {
//                    innerBox.getChildren().addAll(new ButtonBuilder().build(station));
//                }
//            }
//            outerBox.getChildren().addAll(innerBox);
//            blockIndex++;
//        }
//        outerBox.setStyle(Styling.FRONTAGE_PANE_CSS);
//        return outerBox;
////        VBox vBox = new VBox(buildingsButtonsBar, stationsButtonBar);
////        vBox.setStyle(Styling.FRONTAGE_PANE_CSS);
////        return vBox;
//    }
//
//    public HBox hBox () {
//        innerVBox = (VBox) addNodes();
//        outerHBox.getChildren().addAll(innerVBox);
//        return outerHBox;
//    }
//
//    public VBox vBox () {
//        innerHBox = (HBox) addNodes();
//        outerVBox.getChildren().addAll(innerHBox);
//        return outerVBox;
//    }
//
//    public HBox hBox () {
//        int blockIndex = 0;
//        Iterator<Addressables> blockIterator = frontage.blocks().iterator();
//        while (blockIterator.hasNext()) {
//            VBox vBox = new VBox();
//            Addressables block = blockIterator.next();
//            vBox.getChildren().addAll(new ButtonBarBuilder().build(block));
//            Iterator<OldStationable> stationIterator = frontage.stations().iterator();
//            while (stationIterator.hasNext()) {
//                OldStationable station = stationIterator.next();
//                if (station.getAddress().getBlockId() == blockIndex) {
//                    vBox.getChildren().addAll(new ButtonBuilder().build(station));
//                }
//            }
//            hBox.getChildren().addAll(vBox);
//            blockIndex++;
//        }
//        hBox.setStyle(Styling.FRONTAGE_PANE_CSS);
//        return hBox;
//    }

//    public Pane addNodes () {
//        int index = 0;
//        Pane pane = new Pane();
//        for (Addressables block: frontage.blocks()) {
//            pane.getChildren().addAll(new ButtonBarBuilder().build(block));
//            Iterator<OldStationable> iterator = frontage.stations().iterator();
//            while (iterator.hasNext()) {
//                OldStationable station = iterator.next();
//                if (station.getAddress().blockId() == index)
//                    pane.getChildren().addAll(new ButtonBuilder().build(station));
//            }
//            index++;
//        }
//        return pane;
//    }


//    public Group getGroup () {
//        Group group = new Group();
//        if (RoadCategory.isAvenue(frontage.trafficDirection())) {
//            VBox vBox = new VBox(buildingsButtonsBar, stationsButtonBar);
//            vBox.setStyle(Styling.FRONTAGE_PANE_CSS);
//            group.getChildren().addAll(vBox);
//        }
//        else {
//            HBox hBox = new HBox(buildingsButtonsBar, stationsButtonBar);
//            hBox.setStyle(Styling.FRONTAGE_PANE_CSS);
//            group.getChildren().addAll(hBox);
//        }
//        return group;
//    }
}

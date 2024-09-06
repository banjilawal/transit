//package com.lawal.transit.fx;
//
//import com.lawal.transit.blocks.interfaces.*;
//import javafx.scene.layout.*;
//
//import java.util.*;
//
//public class AvenueBlockFx {
//
//    private RoadSectionals blocks;
//
//    public AvenueBlockFx (RoadSectionals blocks) {
//        this.blocks = blocks;
//    }
//
//    public VBox vBox () {
//        VBox vBox = new VBox();
//        Iterator<Addressables> iterator = blocks.iterator();
//        while (iterator.hasNext()) {
//            Addressables block = iterator.next();
//            vBox.getChildren().addAll(new ButtonBarBuilder().build(block));
//        }
//        return vBox;
//    }
//}
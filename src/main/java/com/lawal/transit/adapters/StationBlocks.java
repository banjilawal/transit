//package com.lawal.transit.adapters;
//
//import com.lawal.transit.blocks.interfaces.*;
//import com.lawal.transit.graph.interfaces.Edgeable;
//import com.lawal.transit.stations.interfaces.*;
//
//import java.util.*;
//
//public class StationBlocks {
//
//    private ArrayList<Edgeable> edges;
//
//
//    public void processStations (Stationables stations) {
//        ArrayList<RoadSectionTag> blockTags = new ArrayList<>();
//        Iterator<Vertex> iterator = stations.iterator();
//        while (iterator.hasNext()) {
//            Vertex station = iterator.next();
//            RoadSectionTag blockTag = station.key().blockTag();
//            if (!blockTags.contains(blockTag))
//                blockTags.add(blockTags.size(), blockTag);
//
//        }
//    }
//}
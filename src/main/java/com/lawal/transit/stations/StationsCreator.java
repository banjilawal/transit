package com.lawal.transit.stations;


import com.lawal.transit.addressing.Address;
import com.lawal.transit.addressing.Addressable;
import com.lawal.transit.blocks.interfaces.RoadSectional;
import com.lawal.transit.graph.Edges;
import com.lawal.transit.globals.Direction;
import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.globals.NameGenerator;
import com.lawal.transit.graph.VertexColor;

import java.util.ArrayList;

public final class StationsCreator {

    private ArrayList<RoadSectional> targetBlocks;

    public StationsCreator() {}

    public ArrayList<RoadSectional> getTargetBlocks () {
        return targetBlocks;
    }

    public StationsCreator targetBlocks (ArrayList<RoadSectional> targetBlocks) {
        this.targetBlocks = targetBlocks;
        return this;
    }

    public Stations getProduct () throws Exception {
        if ( targetBlocks == null || targetBlocks.isEmpty() ) { return new Stations();   }
        else {
            Direction travelDirection = targetBlocks.get(0).tag().curbsideMarker().travelDirection();
            Stations stations = new Stations();
            for (RoadSectional targetBlock : targetBlocks) {
                Addressable key = new Address.Builder().id(IdGenerator.INSTANCE.nextStationID())
                    .name(NameGenerator.INSTANCE.stationName(travelDirection))
                    .blockTag(targetBlock.tag())
                    .build();
                stations.add(new Station(key));
            }
            return stations;
        }
    }
}
package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.road.interfaces.*;
import javafx.scene.canvas.*;

import java.util.*;

public class CityRoad implements GraphicRenderer, Road {

    private RoadLabeler label;
    private LaneCollectable lanes;

    public CityRoad (RoadLabeler roadLabeler, TrafficLanes lanes) {
        this.label = roadLabeler;
        this.lanes = lanes;
    }


    public RoadLabeler getLabel () {
        return label;
    }

    @Override
    public LaneCollectable getLanes () {
        return lanes;
    }

    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Road road) {
            return label.equals(road.getLabel());
        }
        return false;
    }

    @Override
    public void render (GraphicsContext gc) {

    }

}

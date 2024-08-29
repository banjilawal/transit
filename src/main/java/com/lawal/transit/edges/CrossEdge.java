package com.lawal.transit.edges;

import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

public class CrossEdge implements Edgeable {
    public static EdgeCategory CATEGORY = EdgeCategory.CROSS;

    @Override
    public Stationable head () {
        return null;
    }

    @Override
    public Stationable tail () {
        return null;
    }

    @Override
    public EdgeProperties properties () {
        return null;
    }

    public static class Builder {
        private Stationable avenueStation;
        private Stationable streetStation;
        private Stationable head;
        private Stationable tail;

        public Builder avenueStation (Stationable avenueStation) {
            this.avenueStation = avenueStation;
            return this;
        }

        public Builder streetStation (Stationable streetStation) {
            this.streetStation = streetStation;
            return this;
        }

        private void setVertices () {
            Orientation streetTrafficDirection = streetStation.trafficDirection();
            if (streetStation.trafficDirection(). && avenueStation.trafficDirection())
            if (streetStation.key().id() && streetStation.key().blockTag().> avenueStation.key().id()) {
                this.head = streetStation;
                this.tail = avenueStation;
            }
            else if (streetStation.key().id() == avenueStation.key().id()) {
                this.head = avenueStation;
                this.tail = streetStation;
            }

        }
    }
}

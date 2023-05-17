package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.RoadDirection;
import com.lawal.transit.middleware.singletons.Stations;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Road extends DuplexPath {
    public RoadCategory roadCategory;
    public RoadDirection roadDirection;

    public Road(int id, String name, SimplexPath forwardPath, SimplexPath reversePath, RoadDirection roadDirection, RoadCategory roadCategory) {
        super(id, name, forwardPath, reversePath);
        this.roadDirection = roadDirection;
        this.roadCategory = roadCategory;
    }

    public RoadCategory getRoadCategory () {
        return roadCategory;
    }

    public RoadDirection getRoadDirection() {
        return roadDirection;
    }

    public void setCategory (RoadCategory roadCategory) {
        this.roadCategory = roadCategory;
    }

    public void setRoadCategory(RoadCategory roadCategory) {
        this.roadCategory = roadCategory;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof  Road) {
            Road road = (Road) object;
            if (super.equals(road)) {
                if (roadCategory.compareTo(road.getRoadCategory()) == 0) {
                    if (roadDirection.compareTo(road.getRoadDirection()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roadCategory, roadDirection);
    } // close hashCode

    @Override
    public String toString () {
        return getName() + " " + getRoadCategory().abbreviation();
    } // close toString

    @Override
    public String fullString () { return "id:" + getId() + " " + toString(); }

    public ArrayList<String> getStations () {
        return Stations.INSTANCE.filter(this);
    } // close getStations
} // end class Road

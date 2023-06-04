package com.lawal.transit.core.singletons;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.entities.Station;
import com.lawal.transit.middleware.graph.Edge;

import java.util.Comparator;

public class StationPaths {
    private static final long serialVersionUID = 1L;
    private static int serialNumber = 1;
    private Bag<Edge> edges = new Bag<Edge>();
    private Bag<Station> stations = new Bag<Station>();
    private Bag<TransitRoute> busRoutes = new Bag<TransitRoute>();
    private static StationPaths singleton = null;

    private StationPaths () {
    } // close constructor

    public static StationPaths getInstance () {
        if (singleton == null) {
            singleton = new StationPaths();
        }
        return singleton;
    } // close getInstance

    public Bag<Edge> getEdges () {
        return edges;
    }

    public Bag<Station> getStations () {
        return stations;
    }

    public Bag<TransitRoute> getBusRoutes () {
        return busRoutes;
    }

    public String toString () {
        return "Stations\n" + stations.toString() + "\n"
                + "\nBus Routes\n" + busRoutes.toString() + "\n"
                + "\nEdges\n" + edges.toString();
    } // close toString

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber;

    public static class StationComparator implements Comparator<Station> {

        public int compareID (Station a,  Station b) {
            return compare(a, b);
        } // close compareID

        @Override
        public int compare (Station a,  Station b) {
            return a.getId() - b.getId();
        } // close compare
        public int compareDirection (Station a,  Station b) {
            return a.getOrientation().compareTo(b.getOrientation());
        } // close compareDirection

        public int compareMultiVariables (Station a,  Station b) {
            int directionComparison = compareDirection(a,  b);

            if (directionComparison > 0) {
                return compare(a,  b );
            } else if (directionComparison < 0) {
                return compare(b,a);
            }
            return compare(a, b);
        } // close comparMultipleVariables
    } // end class StationComparator

} // end class StationPaths
*/
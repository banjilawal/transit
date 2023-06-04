package com.lawal.transit.core.graph;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.collections.TimeBag;
import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.entities.Station;

import java.util.Objects;

public class Edge extends Item {
    private TimeBag  tailArrivals;
    private TransitRoute transitRoute;
    private Station head;
    private Station tail;

    public Edge (int id, String name, TransitRoute transitRoute, Station head, Station tail) {
        super(id, name);
        this.transitRoute = transitRoute;
        this.head = head;
        this.tail = tail;
        this.setName(edgeName(transitRoute,head,tail));
        this.tailArrivals = new TimeBag();
    } // close constructor

    public TransitRoute getBusRoute () {
        return transitRoute;
    }

    public Station getHead () {
        return head;
    }
    public Station getTail () {
        return tail;
    }

    public TimeBag getTailArrivals () { return tailArrivals; }

    public void setBusRoute (TransitRoute transitRoute) {
        this.transitRoute = transitRoute;
    }

    public void setHead (Station head) {
        this.head = head;
    }

    public void setTail (Station tail) {
        this.tail = tail;
    }

    @Override
    public boolean equals (Object object) {
        boolean isEqual = false;

        if (object instanceof Edge)  {
            Edge edge = (Edge) object;

            if (super.equals(edge)) {
                if (this.head.equals(edge.getHead()) && this.tail.equals(edge.getTail())) {
                    if (this.transitRoute.equals(edge.getBusRoute())) {
                        isEqual = true;
                    }
                }
            }
        }
     return isEqual;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), transitRoute, head, tail);
    }

    @Override
    public String toString () {
        String string = super.toString()
                + "[" + head.getName() + "]"
                + "---" + transitRoute.getId() + "-->"
                + " [" + tail.getName()
                + ", " + tailArrivals.toString()
                + "]";
        return string;
    }

    private String edgeName (TransitRoute transitRoute, Station head, Station tail) {
        return head.getName() + Integer.toString(transitRoute.getId()) + tail.getName();
    }
} // end class Edge
*/
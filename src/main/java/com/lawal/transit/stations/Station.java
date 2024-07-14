package com.lawal.transit.stations;


import com.lawal.transit.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.graph.interfaces.*;
import javafx.scene.canvas.*;

import java.util.*;

public class Station implements Vertex {

    private final FormattedAddress address;
    private final EdgeCollection incomingEdges;
    private final EdgeCollection outgoingEdges;

    public Station (
        FormattedAddress address
    ) {
        this.address = address;
        this.incomingEdges = new Edges();
        this.outgoingEdges = new Edges();
    }

    @Override
    public FormattedAddress getAddress () {
        return address;
    }

    @Override
    public EdgeCollection getIncomingEdges () {
        return incomingEdges;
    }

    @Override
    public EdgeCollection getOutgoingEdges () {
        return outgoingEdges;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object instanceof Station station)
            return address.equals(station.getAddress())
                && incomingEdges.getDegree() == station.getIncomingEdges().getDegree()
                && outgoingEdges.getDegree() == station.getOutgoingEdges().getDegree();
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(address, incomingEdges.getDegree(), outgoingEdges.getDegree());
    }

    @Override
    public String toString () {
        return address.getName() + address.getOrientation().abbreviation();
    }
}

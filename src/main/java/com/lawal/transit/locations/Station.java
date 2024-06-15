package com.lawal.transit.locations;


import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;
import javafx.scene.canvas.*;

public class Station implements DirectedVertex<LocationAddressable>, GraphicRenderer {

    private final LocationAddressable address;
    private final EdgeCollection<DirectedVertex<LocationAddressable>> incomingEdges;
    private final EdgeCollection<DirectedVertex<LocationAddressable>> outgoingEdges;

    public Station (
        LocationAddressable address,
        EdgeCollection<DirectedVertex<LocationAddressable>> incomingEdges,
        EdgeCollection<DirectedVertex<LocationAddressable>> outgoingEdges
    ) {
        this.address = address;
        this.incomingEdges = incomingEdges;
        this.outgoingEdges = outgoingEdges;
    }

    @Override
    public LocationAddressable getAddress () {
        return address;
    }

    @Override
    public EdgeCollection<DirectedVertex<LocationAddressable>> getIncomingEdges () {
        return incomingEdges;
    }

    @Override
    public EdgeCollection<DirectedVertex<LocationAddressable>> getOutgoingEdges () {
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
    public void render (GraphicsContext gc) {

    }

}

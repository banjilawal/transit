package com.lawal.transit.sections;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.sections.interfaces.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;

public class Block implements GraphicRenderer, GridSection<Addressable> {

    private final Addressable addressable;
    private final BorderCollection borders;
    private final EdgeCollection<UndirectedVertex<Addressable>> edges;

    public Block (Addressable addressable, Borders borders, EdgeCollection<UndirectedVertex<Addressable>> edges) {
        this.addressable = addressable;
        this.borders = borders;
        this.edges = edges;
    }

    @Override
    public Addressable getAddress () {
        return addressable;
    }

    @Override
    public BorderCollection getBorders () {
        return borders;
    }

    @Override
    public EdgeCollection<UndirectedVertex<Addressable>> getEdges () {
        return edges;
    }
    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Block block) {
            return addressable.equals(block.getAddress());
        }
        return false;
    }

    @Override
    public void render (GraphicsContext gc) {

    }

    public Pane getBlockPane () {
        return null;
    }

}

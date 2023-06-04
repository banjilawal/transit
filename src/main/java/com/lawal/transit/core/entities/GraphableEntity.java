/*package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.AbstractGraphableEntity;
import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.core.enums.GraphableEntityType;
import com.lawal.transit.core.interfaces.AbstractGraphableEntityFactory;
import com.lawal.transit.core.interfaces.Graphable;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GraphableEntity<T> extends AbstractGraphableEntity, implements Graphable {

    public GraphableEntity (int id, String name, GraphableEntityType type) {
        super(id, name);
    }

    public Iterator<T> getNeighbors () {
        return neighbors.iterator();
    } // close getNeighbors

    public void addNeighbors (ArrayList<T> neighbors) {
        for (Block neighbor : neighbors) {
            addNeighbor(neighbor);
        }
    } // close setNeighbors

    public void addNeighbor (T neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbors.size(), neighbor);
        }
    } // close addNeighbor

    public void removeNeighbors (ArrayList<T> neighbors) {
        for (T neighbor : neighbors) {
            removeNeighbor(neighbor);
        }
    } // close removeNeighbors

    public void removeNeighbor (T neighbor) {
        int index = neighbors.indexOf(neighbor);
        if (index >= 0) {
            neighbors.remove(index);
        }
    } // close removeNeighbor
} // end class NamedEntity*/

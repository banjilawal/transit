/*package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.GraphableEntity;
import com.lawal.transit.core.enums.GraphableEntityType;
import com.lawal.transit.core.interfaces.AbstractGraphableEntityFactory;
import com.lawal.transit.core.interfaces.Graphable;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractGraphableEntity<T> extends NamedEntity {

    public AbstractGraphableEntity (int id, String name) {
        super(id, name);
    }

    public Iterator<T> getNeighbors () {
        return neighbors.iterator();
    } // close getNeighbors

    public void addNeighbors (ArrayList<T> neighbors) {
        for (T neighbor : neighbors) {
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

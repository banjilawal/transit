package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.interfaces.Identifiable;

public abstract class FixedPath extends NamedEntity {
    private int id;
    private String name;

    public FixedPath (int id, String name) {
        super(id, name);
    }
} // end class Path

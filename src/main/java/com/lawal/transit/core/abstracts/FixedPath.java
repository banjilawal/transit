package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.interfaces.Identifiable;

public abstract class FixedPath extends Path implements Identifiable {
    private int id;
    private String name;

    public FixedPath (int id, String name) {
        super();
        this.id = id;
        this.name = name;
    } //

    @Override
    public int getId () {
        return id;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public void setId (int id) {
        this.id = id;
    }

    @Override
    public void setName (String name) {
        this.name = name;
    }
} // end class Path

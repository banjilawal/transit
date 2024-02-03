package com.lawal.transit.core.abstracts;

import static java.util.Objects.hash;

public abstract class Entity extends AnonymousEntity {
    private int id;

    public Entity (int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Entity entity) return id == entity.getId();
        return false;
    }

    @Override
    public int hashCode () {
        return hash(id);
    }

    @Override
    public String toString () {
        return super.toString() + " id:" + id;
    }
} // end class Entity

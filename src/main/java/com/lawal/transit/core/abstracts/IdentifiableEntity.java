package com.lawal.transit.core.abstracts;

import static java.util.Objects.hash;

public abstract class IdentifiableEntity extends Entity {
    private int id;

    public IdentifiableEntity (int id) {
        this.id = id;
    } // close constructor

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof IdentifiableEntity) {
            IdentifiableEntity ie = (IdentifiableEntity) object;
            if (id == ie.getId()) {
                return true;
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return hash(id);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString() + " id:" + id;
    } // close toString
} // end class IdentifiableEntity

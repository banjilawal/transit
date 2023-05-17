package com.lawal.transit.middleware.abstracts;

import java.util.Objects;

public abstract class Item extends NamedEntity {
    private int id;
    private String name;

    public Item() {
        this(Integer.MIN_VALUE, "none");
    } // close constructor

    public Item(int id, String name) {
        super(id, name);
        this.id = id;
        this.name = name;
    } // close constructor

    public int getId () {
        return this.id;
    } // close getId
    public String getName () {
        return this.name;
    }

    public void setId (int id) {
        this.id = id;
    } // close setId
    public void setName (String name) {
        this.name = name;
    } // close setName


    @Override
    public boolean equals (Object object) {
        boolean isEqual = false;

        if (object instanceof Item item) {

            if (this.id == item.getId() && this.name.equalsIgnoreCase(item.getName())) {
                isEqual = true;
            }
        }
        return isEqual;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(this.id, this.name);
    } // close hashCode

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName()
                + " id:" + this.id
                + " name:" + this.name;
        return string;
    } // close toString
} // end class NamedEntity

package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.exception.IdentifiableEntityException;
import java.lang.String;
import static java.util.Objects.hash;

public abstract class NamedEntity extends Entity {
    private String name;

    public NamedEntity (int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof NamedEntity namedEntity) {
            return super.equals(namedEntity) && name.equalsIgnoreCase(namedEntity.getName());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return hash(super.hashCode(), name);
    }

    @Override
    public String toString () {
        return  super.toString() + " name:" + name;
    }

    private int validateId (int id) {
        try {
            if (id < 0) {
                String errorMessage = generateErrorMessage("validateId","", 75, IdentifiableEntityException.PREFIX);
                throw new IdentifiableEntityException(errorMessage);
            }
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }
        return id;
    } // close validateName

    private String validateName (String name) {
        try {
            if (name.isBlank() || name.isBlank()) {
                String errorMessage = generateErrorMessage("validateName","", 90, IdentifiableEntityException.PREFIX);
                throw new IdentifiableEntityException(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return name;
    } // close validateName
} // end class NamedEntity

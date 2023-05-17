package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.exception.IdentifiableEntityException;
import java.lang.String;
import static java.util.Objects.hash;

public abstract class NamedEntity extends IdentifiableEntity {
    private String name;

    public NamedEntity (int id, String name) {
        super(id);
        this.name = name; // validateName(name);
    } // close constructor

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = validateName(name);
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof NamedEntity) {
            NamedEntity namedEntity = (NamedEntity) object;
            if (super.equals(namedEntity) && name.equalsIgnoreCase(namedEntity.getName())) {
                return true;
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return hash(super.hashCode(), name);
    } // close hashCode

    @Override
    public String toString () {
        String string = super.toString() + " name:" + name;
        return string;
    } // close toString

    public String fullString () {
        return toString();
    } // close toString

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

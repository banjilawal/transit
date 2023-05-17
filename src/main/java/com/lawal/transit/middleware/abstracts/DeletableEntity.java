package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.exception.IdentifiableEntityException;

public abstract class DeletableEntity extends Entity {
/*
    private String name;

    public DeletableEntity (int id, String name) throws IdentifiableEntityException {

        this.name = validateName(name);
    } // close constructor

    //------------------ Getters ------------------//


    public String getName () {
        return name;
    }

    //------------------ Setters ------------------//


    public void setName (String name) throws IdentifiableEntityException {
        this.name = validateName(name);
    }

    //------------------ Overrides ------------------//
    @Override
    public boolean equals (Object object) {
        boolean isEqual = false;
        if (object instanceof DeletableEntity) {
            DeletableEntity nameableEntity = (DeletableEntity) object;

            if (this.id == nameableEntity.getId()) {
                if (this.name.equalsIgnoreCase(nameableEntity.getName())) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public int hashCode () {
        return hash(id, name);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString() + " name:" + name;
    } // close toString

    //------------------ Helpers ------------------//
    public String fullString () {
        return super.toString() + " id:" + id + " name:" + name;
    } // close toString
    private int validateId (int id) throws IdentifiableEntityException {
        if (id < 0) {
            String errorMessage = this.getClass().getSimpleName().toString()
                    + " " + IdentifiableEntityIdException.prefix
                    + " line: 49";
            throw new IdentifiableEntityException(errorMessage);
        }
        return id;
    } // close validateName

    private String validateName (String name) throws  IdentifiableEntityException {
        if (name.isBlank() || name.isBlank()) {
            String errorMessage = this.getClass().getSimpleName().toString()
                    + " " + IdentifiableEntityException.prefix
                    + " line: 59";
            throw new IdentifiableEntityException(errorMessage);
        }
        return name;
    } // close validateName


    //------------------ Statics ------------------//
 */
} // end class NamedEntity

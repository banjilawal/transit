package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.abstracts.Singleton;

import java.util.ArrayList;
import java.util.Objects;

public abstract class EntitySingletonList {

    private final ArrayList<Item> list;

    private static final Singleton singleton = null;
    public EntitySingletonList () {
        this.list = new ArrayList<Item>();
    } // close constructor


   // public NamedEntity get (int index) {
   //     return this.list.get(index);
  //  } // close get

  //  public int getTotal () {
  //      return list.size();
   // }
/*
    public void add (NamedEntity entity) {
        if (list.contains(entity)) {
            String entityClassName = entity.getClass().getSimpleName().toString();
            String singletonClassName = this.getClass().getSimpleName().toString();

            String errorMessage = singletonClassName
                    + " add operation failed:"
                    + " " + entityClassName
                    + " " + entity.getName()
                    + " already member of"
                    + " " +singletonClassName;
            throw new UnsupportedOperationException(errorMessage);
        }
        System.out.println("adding: " + this.toString());
        this.list.add(entity);
    } // close add
*/
    @Override
    public int hashCode () {
        return Objects.hash(list);
    }

    protected int nextSerialNumber (int serialNumber) {
        return serialNumber++;
    } // close

} // end class Singleton

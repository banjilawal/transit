package com.lawal.transit.core.collections;

import com.lawal.transit.core.abstracts.NamedEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class OldBag<E>  {
   // private static int serialNumber = 1;
    private final ArrayList<NamedEntity> bag;

    public OldBag () {
        bag = new ArrayList<NamedEntity>();
    }

    public ArrayList<NamedEntity> getBag () {
        return bag;
    }

    public int size () {
        return bag.size();
    } // close size

    public NamedEntity get(int index) {
        return bag.get(index);
    }

    public boolean contains (NamedEntity entity) {
        return (bag.contains(entity));
    }

    public NamedEntity search (int id) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.getId() == id) {
                return namedEntity;
            }
        }
        return null;
    } // close search

    public NamedEntity search (String name) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.getName().equalsIgnoreCase(name)) {
                return namedEntity;
            }
        }
        return null;
    } // close search

    public NamedEntity search (NamedEntity target) {
        for (NamedEntity namedEntity : bag) {
            if (namedEntity.equals(target)) {
                return namedEntity;
            }
        }
        return null;
    } // close search

    public void add (int index, NamedEntity namedEntity) {
        if (!bag.contains(namedEntity)) {
            bag.add(index, namedEntity);
        }
    } // close

    public boolean add (NamedEntity namedEntity) {
        if (bag.contains(namedEntity)) {
            return false;
        }
        return bag.add(namedEntity);
    } // close

    public boolean remove (int id) {
        NamedEntity namedEntity = search(id);
        if (namedEntity == null) {
            return false;
        }
        return bag.remove(namedEntity);
    } // close remove

    public boolean remove (String name) {
        NamedEntity namedEntity = search(name);
        if (namedEntity == null) {
            return false;
        }
        return bag.remove(namedEntity);
    } // close remove

    public boolean remove (NamedEntity namedEntity) {
        return bag.remove(namedEntity);
    } // close remove

    public Iterator iterator () {
        return bag.iterator();
    }

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName() + "\n---------------------------";
        for (NamedEntity namedEntity : bag) {
            string += "\n" + namedEntity.toString(); //namedEntity.getName() + " " + namedEntity.getId();
        }
        return string;
    } // close to String

    public String fullString () {
        return toString();
//        String string = this.getClass().getSimpleName() + "\n---------------------------";
//        for (NamedEntity identifiableEntity : bag) {
//            string += "\n[" + identifiableEntity.fullString() + "]";
//        }
//        return string;
    } // close to String
} // end class Bag

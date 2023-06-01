package com.lawal.transit.middleware.collections;

import com.lawal.transit.middleware.abstracts.NamedEntity;
import com.lawal.transit.middleware.entities.GlobalConstant;
import com.lawal.transit.middleware.enums.SearchCategory;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag<E>  {
    private final ArrayList<E> bag;

    public Bag () {
        bag = new ArrayList<E>();
    }

    public ArrayList<E> getBag () {
        return bag;
    }

    public int size () {
        return bag.size();
    } // close size

    public int indexOf (E e) {
        return bag.indexOf(e);
    } // close getIndex

    public E get(int index) {
        return bag.get(index);
    }

    public boolean contains (E e) {
        return (bag.contains(e));
    }

    public E search (int id) {
        return search("", id);
    } // close search

    public E search (String name) {
        return search(name, Integer.MIN_VALUE);
    } // close search

    private E search (String name, int id) {
        if (!name.isBlank()) {
            for (E e : bag) {
                NamedEntity ne = (NamedEntity) e;
                if (ne.getName().equalsIgnoreCase(name)) {
                    return e;
                }
            }
        }
        if (id >= GlobalConstant.MINIMUM_ENTITY_ID) {
            for (E e : bag) {
                NamedEntity ne = (NamedEntity) e;
                if (ne.getId() == id) {
                    return e;
                }
            }
        }
        return null;
    } // close search

    public void add (E e) {
        add(bag.size(), e);
    } // close add

    public void add (int index, E e) {
        if (!bag.contains(e)) {
            bag.add(index, e);
        }
    } // close add

    public boolean remove (int id) {
        return remove("", id);
    } // close remove

    public boolean remove (String name) {
        return remove(name, Integer.MIN_VALUE);
    } // close remove

    public E remove (E e) {
        return bag.remove(bag.indexOf(e));
    } // close remove

    private boolean remove (String name, int id) {
        E e = null;
        if (!name.isBlank()) {
            e = search(name);
        }
        if (id >= GlobalConstant.MINIMUM_ENTITY_ID) {
            e = search(id);
        }
        if (e != null) {
            return bag.remove(e);
        }
        return false;
    } // close remove

    public Iterator iterator () {
        return bag.iterator();
    }

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName() + "s\n---------------------------";
        for (E e : bag) {
            NamedEntity ne = (NamedEntity) e;
            string += "\n" + ne.toString(); //namedEntity.getName() + " " + namedEntity.getId();
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

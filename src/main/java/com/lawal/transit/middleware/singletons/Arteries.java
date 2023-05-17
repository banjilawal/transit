package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.Item;

import java.io.Serializable;
import java.util.Iterator;

public class Arteries implements Serializable {
    private static final long serialVersionUID =  1L;
    private static Arteries singleton;
    private final Bag<Road> arteries = new Bag<Road>();
    private static int serialNumber = 1;

    private Arteries () {

    } // close constructor

    public static Arteries getInstance() {
        if (singleton == null) {
            singleton = new Arteries();
        }
        return singleton;
    } // close getInstance

    public Bag<Road> getArteries () {
        return arteries;
    }

    public Iterator<Item> iterator () {
        return arteries.iterator();
    } // close iterator

    public Road search (int roadId) {
        return (Road) this.arteries.search(roadId);
    } //

    public boolean add (Road road) {
        return this.arteries.add(road);
    }

    public boolean remove (Road road) {
        return this.arteries.remove(road.getId());
    }
/*
    public Road search (int id) {
        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road artery = iterator.next();
            if (artery.getId() == id) {
                return artery;
            }
        }
        return null;
    } // close search

    public Road search (String name) {
        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road artery = iterator.next();
            if (artery.getName().equalsIgnoreCase(name)) {
                return artery;
            }
        }
        return null;
    } // close search

    public boolean remove (int id) {
        Road artery = search(id);
        if (artery == null) {
            return false;
        }
        else return arteries.remove(artery);
    } // close removeRoad

    public boolean remove (String name) {
        Road artery = search(name);
        if (artery == null) {
            return false;
        }
        else return arteries.remove(artery);
    } // close removeRoad

    public boolean add (Road artery) {
        if (arteries.contains(artery)) {
            return false;
        }
        return arteries.add(artery);
    } // close addRoad

    public Iterator<Road> iterator () {
        return arteries.iterator();
    } // close iterator

    public int size () {
        return arteries.size();
    } // close getRoadTotal


    public int getTotalBlocks () {
        return (int) Math.pow(arteries.size(), 2);
    } /// close getBlockTotal

    public int getBlocksPerRoad () {
        return arteries.size() / 2;
    }

    @Override
    public String toString () {
        String string = "Arteries\n-----";

        for (Road artery : arteries) {
            string += "\n" + artery.toString();
        }
        return string;
    } // close toString
*/
    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber

} // end class Arteries


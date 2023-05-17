package com.lawal.transit.middleware.singletons;
/*
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.graph.Edge;

import java.io.Serializable;

public class Edges implements Serializable {
    private static final long serialVersionUID = 1L;
   // private ArrayList<Address> addresses = new ArrayList<Address>();
    private Bag<Edge> edges = new Bag<Edge>();
    private static Edges singleton = null;
    private static int serialNumber = 1;
    private Edges () {
        super();
    } // close constructor

    public static Edges getInstance() {
        if (singleton == null) {
            singleton = new Edges();
        }
        return singleton;
    } // close getInstance

    public Bag<Edge> getEdges () {
        return edges;
    }
/*
    public Address search (int id) {
        for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            if (address.getId() == id) {
                return address;
            }
        }
        return null;
    } // close search

    public Address search (String name, Road artery) {
        for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            if (address.getName().equalsIgnoreCase(name) && address.getArtery().equals(artery)) {
                return address;
            }
        }
        return null;
    } // close search

    public boolean add (Address address) {
       if (addresses.contains(address)) {
           return false;
        }
       return addresses.add(address);
    } // close addAddress

    public boolean remove (int id) {
        Address address = search(id);
        if (address == null) {
            return false;
        }
        return addresses.remove(address);
    } // close addAddress

    public Iterator<Address> iterator () {
        return addresses.iterator();
    } // close iterator

    public int getTotal () {
       return addresses.size();
    } // close getTotal

    public String toString () {
        String string = "Addresses\n----------";
        for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            string += "\n" + address.toString();
        }
        //for (Address address : this.list) {
        //    string += "\nid:" + address.getId() + " " + address.toString();
       // }
        return string;
    } // close toString

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber

} // end class Addresses
*/
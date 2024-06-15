package com.lawal.transit.core.singletons;
/*
import com.lawal.transit.middleware.collections.Bag;
import com.lawal.transit.middleware.concretes.Address;
import com.lawal.transit.middleware.abstracts.Item;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

public class Addresses implements Serializable {
    private static final long serialVersionUID = 1L;
   // private ArrayList<Address> collections = new ArrayList<Address>();
    private Bag<Address> collections = new Bag<Address>();
    private static Addresses singleton = null;
    private static int serialNumber = 1;
    private Addresses () {
    } // close constructor

    public static Addresses getInstance() {
        if (singleton == null) {
            singleton = new Addresses();
        }
        return singleton;
    } // close getInstance

    public Bag<Address> getAddresses () {
        return collections;
    }

    public Iterator<Item> iterator () {
        return collections.iterator();
    } // close iterator

    public Address search (String addressName, String streetName) {
        for (Iterator iterator = collections.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            if (address.getName().equalsIgnoreCase(addressName)) {
                if (address.getArtery().getName().equalsIgnoreCase(streetName)) {
                    return address;
                }
            }
        }
        return null;
    } // close search

    public String toString () {
        String string = "Addresses\n----------";
        for (Iterator<Item> iterator = collections.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            string += "\n" + address.toString();
        }
        return string;
    } // close toString

    Comparator<Address> sortByOrientation = Comparator.comparing(Address::getOrientation);

    Comparator<Address> sortById = Comparator.comparing(Address::getId);
    private class AddressOrientationComparator implements Comparator<Address> {
        @Override
        public int compare (Address a, Address b) {
            return a.getOrientation().compareTo(b.getOrientation());
        }

        @Override
        public Comparator<Address> reversed () {
            return Comparator.super.reversed();
        }
    } // close AddressOrientaionComparator


/*
    public Address search (int id) {
        for (Iterator<Address> iterator = collections.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            if (address.getId() == id) {
                return address;
            }
        }
        return null;
    } // close search

    public Address search (String name, TwoWayRoad artery) {
        for (Iterator<Address> iterator = collections.iterator(); iterator.hasNext();) {
            Address address = (Address) iterator.next();
            if (address.getName().equalsIgnoreCase(name) && address.getArtery().equals(artery)) {
                return address;
            }
        }
        return null;
    } // close search

    public boolean add (Address address) {
       if (collections.contains(address)) {
           return false;
        }
       return collections.add(address);
    } // close addAddress

    public boolean remove (int id) {
        Address address = search(id);
        if (address == null) {
            return false;
        }
        return collections.remove(address);
    } // close addAddress

    public Iterator<Address> iterator () {
        return collections.iterator();
    } // close iterator

    public String toString () {
        String string = "Addresses\n----------";
        for (Iterator<Address> iterator = collections.iterator(); iterator.hasNext();) {
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
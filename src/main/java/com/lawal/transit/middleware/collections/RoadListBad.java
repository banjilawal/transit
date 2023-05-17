package com.lawal.transit.middleware.collections;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.singletons.EntitySingletonList;

import java.util.ArrayList;
import java.util.Iterator;
/*
public class RoadListBad extends EntitySingletonList implements Iterable<Road> {

    private ArrayList<Road> list;
    private static RoadListBad singleton = null;
    private static int serialNumber = 1;

    private RoadListBad () {
        super();
        this.list = new ArrayList<Road>();
    } // close constructor

    public static RoadListBad getInstance() {
        if (singleton == null) {
            singleton = new RoadListBad();
        }
        return singleton;
    } // close getInstance

    @Override
    public Iterator<Road> iterator () {
        return this.list.iterator();
    }

    public ArrayList<Road> getList () {
        return list;
    } // close getList

    public int intersectionDensity () {
        return this.list.size() / 2;
    } // close intersectionDensity

    public int getTotal () {
        return this.list.size();
    }

    public Road get (int index) {
        return this.list.get(index);
    }// close get
    public int roadID (String name) {
        int location = Integer.MIN_VALUE;

        for (Road road : this.list) {
            if (road.getName().equalsIgnoreCase(name)) {
                location = this.list.indexOf(road);
                break;
            }
        }
        return location;
    } // close roadID

    public int blockCount () {
        return (int) Math.pow(this.list.size(), 2);
    } // close blockCount


    public void add (Road road) {
        //super.add(road);
        if (!this.list.contains(road)) {
            this.list.add(road);
        }
    }  // close add

    public void remove (Road road) {
        if (this.list.contains(road)) {
            this.list.remove(this.list.indexOf(road));
        }
    } // close remove

    public Road search (String target) {
        for (Iterator<Road> iterator = this.list.iterator(); iterator.hasNext();) {
            Road road = (Road) iterator.next();
            if (road.getName().equalsIgnoreCase(target)) {
                return road;
            }
        }
        return null;
    } // close search

    public Road getCrossRoad (Road road) {
        Road crossRoad = null;


        return crossRoad;
    } // close getCrossRoad

    public int mapNumber (Road target) {
        for (Iterator<Road> iterator = this.list.iterator(); iterator.hasNext();) {
            Road road = (Road) iterator.next();
            if (road.equals(target)) {
                if (road.getCategory() == RoadCategory.AVENUE) {
                    return road.getId();
                }
                else if (road.getCategory() == RoadCategory.STREET) {
                    Integer streetNumber = Integer.parseInt(road.getName());
                    return streetNumber.intValue();
                }
                else {
                    System.out.println("Something is wrong with this road's category");
                }
            }
        }
        return Integer.MIN_VALUE;
    } // close mapNumber

    public Road search (RoadCategory category, String name) {
        for (Iterator<Road> iterator = this.list.iterator(); iterator().hasNext();) {
            Road road = (Road) iterator.next();
            if (road.getName().equalsIgnoreCase(name) && road.getCategory() == category) {
                return road;
            }
        }
        return null;
    } // close search


    public ArrayList<Road> search (RoadCategory category) {
        ArrayList<Road> arteries = new ArrayList<Road>();

        for (Road road : this.list) {
            if (road.getCategory() == category) {
                arteries.add(road);
            }
        }
        return arteries;
    } // close search

    @Override
    public String toString () {
        String string = "Arteries\n-----";

        for (Road road : this.list) {
            string += "\n" + road.toString();
        }
        return string;
    } // close toString

    public static int nextSerialNumber () {
        return serialNumber++;
    } // close nextSerialNumber
} // end class RoadList
 */


package com.lawal.transit.road;

import com.lawal.transit.global.Direction;
import com.lawal.transit.road.interfaces.Road;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Curbs {

    private final List<Curb> curbs;

    public Curbs () {
        this.curbs = new ArrayList<>();
    }

    public void add (Curb curb) {
        if (curb != null && !curbs.contains(curb)) curbs.add(curb);
    }

    public int size () {
        return curbs.size();
    }


    public Iterator<Curb> iterator () {
        return curbs.iterator();
    }

    public Curb findById (int id) {
        for (Curb curb : curbs) {
            if (curb.getId() == id) return curb;
        }
        return null;
    }

    public void remove (int id) throws Exception {
        Curb curb = findById(id);
        if (curb != null) curbs.remove(curb);
    }

    public Curbs filterByRoad (Road road) {
        Curbs matches = new Curbs();
        for (Curb curb : curbs) {
            if (curb.getMarker().roadLabel().equals(road.label())) matches.add(curb);
        }
        return matches;
    }

    @Override
    public String toString () {
        StringBuilder string = new StringBuilder("Curbs:\n");
        for(Curb curb : curbs) {
            string.append(curb.toString()).append("\n");
        }
        return string.toString();
    }
}
package com.lawal.transit.roadEntity;

import com.lawal.transit.roadEntity.contract.RoadEntity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Curbs {

    private final List<OldCurb> oldCurbs;

    public Curbs () {
        this.oldCurbs = new ArrayList<>();
    }

    public void add (OldCurb oldCurb) {
        if (oldCurb != null && !oldCurbs.contains(oldCurb)) oldCurbs.add(oldCurb);
    }

    public int size () {
        return oldCurbs.size();
    }


    public Iterator<OldCurb> iterator () {
        return oldCurbs.iterator();
    }

    public OldCurb findById (int id) {
        for (OldCurb oldCurb : oldCurbs) {
            if (oldCurb.getId() == id) return oldCurb;
        }
        return null;
    }

    public void remove (int id) throws Exception {
        OldCurb oldCurb = findById(id);
        if (oldCurb != null) oldCurbs.remove(oldCurb);
    }

    public Curbs filterByRoad (RoadEntity roadEntity) {
        Curbs matches = new Curbs();
        for (OldCurb oldCurb : oldCurbs) {
            if (oldCurb.getRoadEntity().equals(roadEntity)) matches.add(oldCurb);
        }
        return matches;
    }

    @Override
    public String toString () {
        StringBuilder string = new StringBuilder("Curbs:\n");
        for(OldCurb oldCurb : oldCurbs) {
            string.append(oldCurb.toString()).append("\n");
        }
        return string.toString();
    }
}
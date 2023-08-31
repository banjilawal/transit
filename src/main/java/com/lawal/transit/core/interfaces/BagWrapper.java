package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.containers.Bag;

import java.util.ArrayList;
import java.util.Iterator;

public interface BagWrapper<T> {
    public int size();
    public void add(T t);
    public void remove(T t);
    public Bag<T> getBag();
    public Iterator<T> iterator();
    public ArrayList<T> getBagContents();


} // end interface BagContents

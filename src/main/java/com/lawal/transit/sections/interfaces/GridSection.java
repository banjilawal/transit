package com.lawal.transit.sections.interfaces;

import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.graph.interfaces.*;

public interface GridSection<Address> extends UndirectedVertex<Address> {

    public BorderCollection getBorders ();
}

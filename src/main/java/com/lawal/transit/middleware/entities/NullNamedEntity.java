package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.NamedEntity;
import com.lawal.transit.middleware.interfaces.NullEntity;

public class NullNamedEntity extends NamedEntity implements NullEntity {
    public NullNamedEntity () {
        super(Integer.MIN_VALUE, "None");
    }
} // end class NullNamedEntity

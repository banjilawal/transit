package com.lawal.transit.core.nulls;

import com.lawal.transit.core.abstracts.NamedEntity;
import com.lawal.transit.core.interfaces.NullEntity;

public class NullNamedEntity extends NamedEntity implements NullEntity {
    public NullNamedEntity () {
        super(Integer.MIN_VALUE, "None");
    }
} // end class NullNamedEntity

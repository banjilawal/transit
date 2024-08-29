package com.lawal.transit.globals;

import com.lawal.transit.search.*;

import java.time.*;

public interface Positionable {

    public FormattedAddress address ();
    public LocalDateTime time ();
}

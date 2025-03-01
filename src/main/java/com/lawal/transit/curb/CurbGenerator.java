package com.lawal.transit.curb;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.catalog.CurbCatalog;
import com.lawal.transit.catalog.StreetCatalog;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;

public class CurbGenerator {

    private static AtomicLong curbId = new AtomicLong();

    public static void generateAvenueCurbs () {
        for (Avenue avenue : AvenueCatalog.INSTANCE.getCatalog()) {
            Road road = avenue.getRoad();

            Curb leftCurb = new Curb(curbId.incrementAndGet(), Avenue.LEFT_CURB_ORIENTATION, road, null);
            Curb rightCurb = new Curb(curbId.incrementAndGet(), Avenue.RIGHT_CURB_ORIENTATION, null, road);
            CurbCatalog.INSTANCE.getCatalog().add(leftCurb);
            CurbCatalog.INSTANCE.getCatalog().add(rightCurb);
        }
    }

    public static void generateStreetCurbs () {
        for (Street street : StreetCatalog.INSTANCE.getCatalog()) {
            Road road = street.getRoad();

            Curb leftCurb = new Curb(curbId.incrementAndGet(), Street.LEFT_CURB_ORIENTATION, road, null);
            Curb rightCurb = new Curb(curbId.incrementAndGet(), Street.RIGHT_CURB_ORIENTATION, null, road);
            CurbCatalog.INSTANCE.getCatalog().add(leftCurb);
            CurbCatalog.INSTANCE.getCatalog().add(rightCurb);
        }
    }
}
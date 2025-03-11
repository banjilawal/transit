package com.lawal.transit.block;

import com.lawal.transit.house.model.House;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AddressCatalog;

import java.util.concurrent.atomic.AtomicLong;

public final class BlockPopulator {

    public static int nextAddressName;
    static AtomicLong addressId = new AtomicLong(0);

    public static int populateBlock (Block block, int startingAddressName, int addressInterval, int numberOfAddresses)  {

        int addressName = startingAddressName;

        for (int index = 0; index < numberOfAddresses; index++) {
            House house = new House();
//            House house  = new House(addressId.incrementAndGet(), addressName + "", block);

            block.getHouses().add(house);
            AddressCatalog.INSTANCE.getCatalog().add(house);
            addressName += addressInterval;
            nextAddressName = addressName;
        }
        return addressName;
    }
}
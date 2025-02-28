package com.lawal.transit.block;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AddressCatalog;
import com.lawal.transit.address.model.Address;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class BlockPopulator {

    public static int nextAddressName;
    static AtomicLong addressId = new AtomicLong(0);

    public static int populateBlock (Block block, int startingAddressName, int addressInterval, int numberOfAddresses)  {

        int addressName = startingAddressName;

        for (int index = 0; index < numberOfAddresses; index++) {
            Address address = new Address();
//            Address address  = new Address(addressId.incrementAndGet(), addressName + "", block);

            block.getAddresses().add(address);
            AddressCatalog.INSTANCE.getCatalog().add(address);
            addressName += addressInterval;
            nextAddressName = addressName;
        }
        return addressName;
    }
}
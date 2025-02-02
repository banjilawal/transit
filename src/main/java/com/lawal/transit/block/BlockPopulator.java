package com.lawal.transit.block;

import com.lawal.transit.catalog.AddressCatalog;
import com.lawal.transit.address.Address;

import java.util.concurrent.atomic.AtomicInteger;

public final class BlockPopulator {

    public static int nextAddressName;
    static AtomicInteger addressId = new AtomicInteger(0);

    public static int populateBlock (Block block, int startingAddressName, int addressInterval, int numberOfAddresses)  {

        int addressName = startingAddressName;

        for (int index = 0; index < numberOfAddresses; index++) {
            Address address  = new Address(addressId.incrementAndGet(), addressName + "", block, block.getTag());

            block.getAddresses().add(address);
            AddressCatalog.INSTANCE.getCatalog().add(address);
            addressName += addressInterval;
            nextAddressName = addressName;
        }
        return addressName;
    }
}
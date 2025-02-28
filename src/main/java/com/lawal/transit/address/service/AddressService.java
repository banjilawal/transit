package com.lawal.transit.address.service;

import com.lawal.transit.address.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) { this.addressRepo = addressRepo; }
}
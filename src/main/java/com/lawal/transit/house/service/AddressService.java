package com.lawal.transit.house.service;

import com.lawal.transit.house.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) { this.addressRepo = addressRepo; }
}
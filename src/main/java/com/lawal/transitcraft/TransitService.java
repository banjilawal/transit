package com.lawal.transitcraft;

import org.springframework.stereotype.Service;

@Service
public class TransitService {

    public String getWelcomeMessage() {
        return "Welcome to the Transit Application!";
    }
}
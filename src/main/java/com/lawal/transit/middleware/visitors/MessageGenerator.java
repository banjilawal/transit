package com.lawal.transit.middleware.visitors;

import com.lawal.transit.middleware.interfaces.MessageAssigner;

public enum MessageGenerator implements MessageAssigner {
    INSTANCE;

    @Override
    public String assignMessage (Object object, String method, String info, int line) {
        String string = object.getClass().getSimpleName()
                + "." + method + " line" + line + ": " + info;
        return string;
    }
} // end class SerialNumberGenerator

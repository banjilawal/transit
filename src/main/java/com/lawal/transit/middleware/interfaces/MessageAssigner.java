package com.lawal.transit.middleware.interfaces;

public interface MessageAssigner {
    String assignMessage (Object object, String method, String info, int line);
} // end class MessageAssigner

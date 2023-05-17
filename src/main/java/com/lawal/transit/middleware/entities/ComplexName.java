package com.lawal.transit.middleware.entities;

public class ComplexName {
    private String start;
    private String middle;
    private String end;

    public ComplexName (String start, String middle, String end) {
        this.start = start;
        this.middle = middle;
        this.end = end;
    }

    public String getStart () {
        return start;
    }

    public String getMiddle () {
        return middle;
    }

    public String getEnd () {
        return end;
    }

    public void setStart (String start) {
        this.start = start;
    }

    public void setMiddle (String middle) {
        this.middle = middle;
    }

    public void setEnd (String end) {
        this.end = end;
    }

    @Override
    public String toString () {
        return  start + middle + end;
    }
} // end class ComplexName

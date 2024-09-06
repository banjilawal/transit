//package com.lawal.transit.fx;
//
//public class StylerizerFactory implements StylerizerableFactorable {
//
//    public StylerizerFactory () {
//    }
//
//
//    private Stylerizerable addressableStylerizer () {
//        String backgroundStyle = " -fx-background-color: lightblue;"
//            + " -fx-background-insets: 0;"
//            + " -fx-background-radius: 0;"
//            + " -fx-width: 2500;"
//            + " -fx-height: 45;";
//        String borderStyle = " -fx-border-color: white transparent white transparent;"
//            + " -fx-border-style: dashed;"
//            + " -fx-border-width: 1 0 1 0;"
//            + " -fx-border-radius: 1 0 1 0;"
//            + " -fx-border-insets: 0";
//        return new Stylerizer(backgroundStyle, borderStyle);
//    }
//
//    private Stylerizerable vertexStylerizer () {
//        String backgroundStyle = " -fx-background-color: white;"
//            + " -fx-background-insets: 3;"
//            + " -fx-background-radius: 2;"
//            + " -fx-width: 2500;"
//            + " -fx-height: 45;";
//        String borderStyle = " -fx-border-color: black;"
//            + " -fx-border-style: solid;"
//            + " -fx-border-width: 3;"
//            + " -fx-border-radius: 2;"
//            + " -fx-border-insets: 3";
//        return new Stylerizer(backgroundStyle, borderStyle);
//    }
//
//    private Stylerizerable laneStylerizer () {
//        String backgroundStyle = " -stroke-dasharray: 5 2;";
//        String borderStyle = "";
//        return new Stylerizer(backgroundStyle, borderStyle);
//    }
//
//    public Stylerizerable roadStylerizer () {
//        return null;
//    }
//
//    @Override
//    public Stylerizerable stylerizer (ComponentCategory componentCategory) {
//        switch (componentCategory) {
//            case ADDRESSABLE -> { return addressableStylerizer(); }
//            case VERTEX -> { return vertexStylerizer(); }
//            case LANE -> { return laneStylerizer(); }
//            case ROAD -> { return roadStylerizer(); }
//        }
//        return null;
//    }
//}
module com.lawal.transit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires static lombok;

//    exports com.lawal.transit.fx;
//    opens com.lawal.transit.fx;

    exports com.lawal.transit.global;
    opens com.lawal.transit.global;

    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;

    exports com.lawal.transit.road;
    opens com.lawal.transit.road;

//    exports com.lawal.transit.places;
//    opens com.lawal.transit.places;

    exports com.lawal.transit.station;
    opens com.lawal.transit.station;
//
//    exports com.lawal.transit.station.interfaces;
//    opens com.lawal.transit.station.interfaces;

//    exports com.lawal.transit.transport;
//    opens com.lawal.transit.transport;

    exports com.lawal.transit.traveler;
    opens com.lawal.transit.traveler;

    //    exports com.lawal.transit.block;
//    opens com.lawal.transit.block;

//    exports com.lawal.transit.JunctionFactory;
//    opens com.lawal.transit.JunctionFactory;


    opens com.lawal.transit to javafx.fxml;
    exports com.lawal.transit;

    exports com.lawal.transit.road.interfaces;
    opens com.lawal.transit.road.interfaces;
    exports com.lawal.transit.places;
    opens com.lawal.transit.places;


    exports com.lawal.transit.block;
    opens com.lawal.transit.block;

    exports com.lawal.transit.block.interfaces;
    opens com.lawal.transit.block.interfaces;
    exports com.lawal.transit.places.interfaces;
    opens com.lawal.transit.places.interfaces;
    exports com.lawal.transit.junction;
    opens com.lawal.transit.junction;
    exports com.lawal.transit.road.creators;
    opens com.lawal.transit.road.creators;
    exports com.lawal.transit.graph.interfaces;
    opens com.lawal.transit.graph.interfaces;
} // close
module com.lawal.transit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;

//    exports com.lawal.transit.fx;
//    opens com.lawal.transit.fx;

    exports com.lawal.transit.globals;
    opens com.lawal.transit.globals;

    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;

    exports com.lawal.transit.roads;
    opens com.lawal.transit.roads;

//    exports com.lawal.transit.places;
//    opens com.lawal.transit.places;

    exports com.lawal.transit.stations;
    opens com.lawal.transit.stations;
//
//    exports com.lawal.transit.stations.interfaces;
//    opens com.lawal.transit.stations.interfaces;

//    exports com.lawal.transit.transport;
//    opens com.lawal.transit.transport;

    exports com.lawal.transit.traveler;
    opens com.lawal.transit.traveler;

    //    exports com.lawal.transit.blocks;
//    opens com.lawal.transit.blocks;

//    exports com.lawal.transit.JunctionFactory;
//    opens com.lawal.transit.JunctionFactory;


    opens com.lawal.transit to javafx.fxml;
    exports com.lawal.transit;

    exports com.lawal.transit.roads.interfaces;
    opens com.lawal.transit.roads.interfaces;
    exports com.lawal.transit.places;
    opens com.lawal.transit.places;


    exports com.lawal.transit.blocks;
    opens com.lawal.transit.blocks;

    exports com.lawal.transit.blocks.interfaces;
    opens com.lawal.transit.blocks.interfaces;
    exports com.lawal.transit.places.interfaces;
    opens com.lawal.transit.places.interfaces;
    exports com.lawal.transit.addressing;
    opens com.lawal.transit.addressing;
    exports com.lawal.transit.junctions;
    opens com.lawal.transit.junctions;
    exports com.lawal.transit.roads.creators;
    opens com.lawal.transit.roads.creators;
    exports com.lawal.transit.graph.interfaces;
    opens com.lawal.transit.graph.interfaces;
} // close
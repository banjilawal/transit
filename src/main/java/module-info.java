module com.lawal.transit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires java.sql;
    requires static lombok;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires spring.core;
    requires spring.beans;

    opens com.lawal.transit to spring.core, javafx.fxml;

    exports com.lawal.transit.global;
    opens com.lawal.transit.global;

    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;

    exports com.lawal.transit.road;
    opens com.lawal.transit.road;

    exports com.lawal.transit.station;
    opens com.lawal.transit.station;

//    exports com.lawal.transit.transport;
//    opens com.lawal.transit.transport;

    exports com.lawal.transit.traveler;
    opens com.lawal.transit.traveler;

    exports com.lawal.transit;

    exports com.lawal.transit.road.contract;
    opens com.lawal.transit.road.contract;

    exports com.lawal.transit.block;
    opens com.lawal.transit.block;

    exports com.lawal.transit.junction;
    opens com.lawal.transit.junction;
    exports com.lawal.transit.road.creation;
    opens com.lawal.transit.road.creation;
    exports com.lawal.transit.graph.contract;
    opens com.lawal.transit.graph.contract;
    exports com.lawal.transit.address;
    opens com.lawal.transit.address;
} // close
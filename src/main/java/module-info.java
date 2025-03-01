module com.lawal.transit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires static lombok;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires spring.core;
    requires spring.beans;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires spring.data.jpa;

    exports com.lawal.transit;
    opens com.lawal.transit to spring.core, javafx.fxml;

    exports com.lawal.transit.global;
    opens com.lawal.transit.global;

    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;



//    exports com.lawal.transit.transport;
//    opens com.lawal.transit.transport;

    exports com.lawal.transit.traveler;
    opens com.lawal.transit.traveler;




    exports com.lawal.transit.graph.contract;
    opens com.lawal.transit.graph.contract;

    exports com.lawal.transit.address;
    opens com.lawal.transit.address;

    exports com.lawal.transit.address.model;
    opens com.lawal.transit.address.model;

    exports com.lawal.transit.address.service;
    opens com.lawal.transit.address.service;

    exports com.lawal.transit.station;
    opens com.lawal.transit.station;

    exports com.lawal.transit.station.model;
    opens com.lawal.transit.station.model;

    exports com.lawal.transit.station.service;
    opens com.lawal.transit.station.service;

    exports com.lawal.transit.curb.model;
    opens com.lawal.transit.curb.model;

    exports com.lawal.transit.curb.repo;
    opens com.lawal.transit.curb.repo;

    exports com.lawal.transit.curb.service;
    opens com.lawal.transit.curb.service;

    exports com.lawal.transit.junction;
    opens com.lawal.transit.junction;

    exports com.lawal.transit.junction.model;
    opens com.lawal.transit.junction.model;

    exports com.lawal.transit.junction.service;
    opens com.lawal.transit.junction.service;
    exports com.lawal.transit.junction.service.exception;
    opens com.lawal.transit.junction.service.exception;

    exports com.lawal.transit.avenue;
    opens com.lawal.transit.avenue;

    exports com.lawal.transit.avenue.model;
    opens com.lawal.transit.avenue.model;

    exports com.lawal.transit.avenue.service;
    opens com.lawal.transit.avenue.service;

    exports com.lawal.transit.street;
    opens com.lawal.transit.street;

    exports com.lawal.transit.street.model;
    opens com.lawal.transit.street.model;

    exports com.lawal.transit.street.service;
    opens com.lawal.transit.street.service;

    exports com.lawal.transit.lane;
    opens com.lawal.transit.lane;

    exports com.lawal.transit.lane.model;
    opens com.lawal.transit.lane.model;

    exports com.lawal.transit.lane.service;
    opens com.lawal.transit.lane.service;

    exports com.lawal.transit.block;
    opens com.lawal.transit.block;

    exports com.lawal.transit.block.model;
    opens com.lawal.transit.block.model;

    exports com.lawal.transit.block.service;
    opens com.lawal.transit.block.service;

    exports com.lawal.transit.edge;
    opens com.lawal.transit.edge;

    exports com.lawal.transit.edge.model;
    opens com.lawal.transit.edge.model;

    exports com.lawal.transit.edge.service;
    opens com.lawal.transit.edge.service;

    exports com.lawal.transit.road;
    opens com.lawal.transit.road;

    exports com.lawal.transit.road.model;
    opens com.lawal.transit.road.model;

    exports com.lawal.transit.road.service;
    opens com.lawal.transit.road.service;

    exports com.lawal.transit.path;
    opens com.lawal.transit.path to javafx.fxml, spring.core;
    exports com.lawal.transit.road.model.exception;
    opens com.lawal.transit.road.model.exception;


} // close
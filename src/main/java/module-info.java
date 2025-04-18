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
    requires java.desktop;

    exports com.lawal.transit;
    opens com.lawal.transit to spring.core, javafx.fxml;

    exports com.lawal.transit.common;
    opens com.lawal.transit.common;

    exports com.lawal.transit.infrastructure.house;
    opens com.lawal.transit.infrastructure.house;

    exports com.lawal.transit.infrastructure.station;
    opens com.lawal.transit.infrastructure.station;

    exports com.lawal.transit.infrastructure.junction;
    opens com.lawal.transit.infrastructure.junction;

    exports com.lawal.transit.infrastructure.avenue;
    opens com.lawal.transit.infrastructure.avenue;

    exports com.lawal.transit.infrastructure.street;
    opens com.lawal.transit.infrastructure.street;

    exports com.lawal.transit.infrastructure.lane;
    opens com.lawal.transit.infrastructure.lane;

    exports com.lawal.transit.infrastructure.block;
    opens com.lawal.transit.infrastructure.block;

    exports com.lawal.transit.infrastructure.road;
    opens com.lawal.transit.infrastructure.road;

    exports com.lawal.transit.common.traversal;
    opens com.lawal.transit.common.traversal;

    exports com.lawal.transit.graph.path;
    opens com.lawal.transit.graph.path to javafx.fxml, spring.core;
    exports com.lawal.transit.infrastructure.road.exception;
    opens com.lawal.transit.infrastructure.road.exception;

    exports com.lawal.transit.infrastructure.avenue.exception;
    opens com.lawal.transit.infrastructure.avenue.exception;
    exports com.lawal.transit.common.exception;
    opens com.lawal.transit.common.exception;
    opens com.lawal.transit.infrastructure.curb;
    exports com.lawal.transit.infrastructure.curb;
    exports com.lawal.transit.infrastructure.junction.exception;
    opens com.lawal.transit.infrastructure.junction.exception;
    exports com.lawal.transit.infrastructure.bus;
    opens com.lawal.transit.infrastructure.bus;
    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;


}
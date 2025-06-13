
module com.lawal.transitcraft {
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
    requires org.hibernate.orm.core;
    requires jdk.xml.dom;

    exports com.lawal.transitcraft;
    opens com.lawal.transitcraft to spring.core, javafx.fxml;

    exports com.lawal.transitcraft.common;
    opens com.lawal.transitcraft.common;

    exports com.lawal.transitcraft.infrastructure.house;
    opens com.lawal.transitcraft.infrastructure.house;

    exports com.lawal.transitcraft.infrastructure.station;
    opens com.lawal.transitcraft.infrastructure.station;

    exports com.lawal.transitcraft.infrastructure.junction;
    opens com.lawal.transitcraft.infrastructure.junction;

    exports com.lawal.transitcraft.infrastructure.avenue;
    opens com.lawal.transitcraft.infrastructure.avenue;

    exports com.lawal.transitcraft.infrastructure.street;
    opens com.lawal.transitcraft.infrastructure.street;

    exports com.lawal.transitcraft.infrastructure.lane;
    opens com.lawal.transitcraft.infrastructure.lane;

    exports com.lawal.transitcraft.infrastructure.block;
    opens com.lawal.transitcraft.infrastructure.block;

    exports com.lawal.transitcraft.infrastructure.road;
    opens com.lawal.transitcraft.infrastructure.road;

    exports com.lawal.transitcraft.common.traversal;
    opens com.lawal.transitcraft.common.traversal;

    exports com.lawal.transitcraft.graph.path;
    opens com.lawal.transitcraft.graph.path to javafx.fxml, spring.core;

    exports com.lawal.transitcraft.infrastructure.road.exception;
    opens com.lawal.transitcraft.infrastructure.road.exception;

    exports com.lawal.transitcraft.infrastructure.avenue.exception;
    opens com.lawal.transitcraft.infrastructure.avenue.exception;

    opens com.lawal.transitcraft.infrastructure.curb;
    exports com.lawal.transitcraft.infrastructure.curb;

    exports com.lawal.transitcraft.infrastructure.junction.exception;
    opens com.lawal.transitcraft.infrastructure.junction.exception;

    exports com.lawal.transitcraft.infrastructure.bus;
    opens com.lawal.transitcraft.infrastructure.bus;

    exports com.lawal.transitcraft.graph;
    opens com.lawal.transitcraft.graph;

    exports com.lawal.transitcraft.common.exception;
    opens com.lawal.transitcraft.common.exception;
}
module com.lawal.transit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;

    exports com.lawal.transit.fx;
    opens com.lawal.transit.fx;

    exports com.lawal.transit.globals;
    opens com.lawal.transit.globals;

    exports com.lawal.transit.graph;
    opens com.lawal.transit.graph;

    exports com.lawal.transit.road;
    opens com.lawal.transit.road;

    exports com.lawal.transit.buildings;
    opens com.lawal.transit.buildings;

    exports com.lawal.transit.stations;
    opens com.lawal.transit.stations;

    opens com.lawal.transit to javafx.fxml;
    exports com.lawal.transit;

} // close
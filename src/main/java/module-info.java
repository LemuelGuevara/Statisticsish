module main {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    exports main;
    exports model;
    exports controllers;
    opens model to javafx.fxml;
    opens main to javafx.fxml;
    opens controllers to javafx.fxml;
}
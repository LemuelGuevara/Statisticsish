module main {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires commons.math3;
    requires java.base;

    exports main;
    opens main to javafx.fxml;
    exports model.statistics;
    opens model.statistics to javafx.fxml;
    exports controllers.text;
    opens controllers.text to javafx.fxml;
    exports controllers.statistics;
    opens controllers.statistics to javafx.fxml;
}
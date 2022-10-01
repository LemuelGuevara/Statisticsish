module main.app.statisticscalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens main.app.statisticscalculator to javafx.fxml;
    exports main.app.statisticscalculator;
}
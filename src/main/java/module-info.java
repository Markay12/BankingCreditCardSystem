module com.example.bankingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.bankingsystem to javafx.fxml;
    exports com.example.bankingsystem;
}
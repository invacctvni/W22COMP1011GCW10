module com.example.w22comp1011gcw10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.w22comp1011gcw10 to javafx.fxml, com.google.gson;
    exports com.example.w22comp1011gcw10;
}
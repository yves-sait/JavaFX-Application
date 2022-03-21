module com.example.javafxtravelexpertlogin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtravelexpertlogin to javafx.fxml;
    exports com.example.javafxtravelexpertlogin;
}
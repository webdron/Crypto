module com.example.coderpro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coderpro to javafx.fxml;
    exports com.example.coderpro;
}
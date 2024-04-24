module com.example.innecontrolki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.innecontrolki to javafx.fxml;
    exports com.example.innecontrolki;
}
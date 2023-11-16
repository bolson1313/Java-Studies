module com.example.po_year2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.po_year2 to javafx.fxml;
    exports com.example.po_year2;
}
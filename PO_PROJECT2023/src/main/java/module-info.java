module ItemdleApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.naming;
    requires org.controlsfx.controls;


    opens Itemdle to javafx.fxml, org.controlsfx.controls, javafx.base;
    exports Itemdle;
}
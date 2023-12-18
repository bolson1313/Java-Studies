module ItemdleApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.naming;
    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;

    opens Itemdle to javafx.fxml, org.controlsfx.controls, javafx.base, org.hibernate.orm.core;
    exports Itemdle;
}
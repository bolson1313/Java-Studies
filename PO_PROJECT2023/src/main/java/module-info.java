module ItemdleApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.naming;
    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;
    requires java.base;

    opens Itemdle to javafx.fxml, org.controlsfx.controls, javafx.base, org.hibernate.orm.core, java.base;
    exports Itemdle;
}
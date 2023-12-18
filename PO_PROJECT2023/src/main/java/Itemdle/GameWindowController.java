package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;


public class GameWindowController {

    private Stage stage;
    @FXML
    private AnchorPane anchorGamePane;

    @FXML
    private Button button;

    @FXML
    private TextField textInput;

    @FXML
    private FlowPane paneInScroll;

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        System.out.println("back to main window");
        new SceneSwitch(anchorGamePane, "MainWindow.fxml");
    }

    @FXML
    void exitButton(ActionEvent event) {
        System.out.println("byebye!");
        System.exit(1);
    }




    @FXML
    void submitButton(ActionEvent event) {

    }
    @FXML
    void textSubmitByClick(ActionEvent event) {
        HBox hbox = new HBox();
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(812);
        hbox.setMaxWidth(812);
        hbox.setId("hboxScroll");
        paneInScroll.setPrefHeight(paneInScroll.getHeight()+50);
        paneInScroll.getChildren().addAll(hbox);
    }
}

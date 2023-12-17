package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class GameWindowController {

    @FXML
    private AnchorPane anchorGamePane;

    @FXML
    private Button button;

    @FXML
    private TextField textInput;

    @FXML
    void submitButton(ActionEvent event) {
        System.out.println("to twoje slowa: " + textInput.getText());
        TextFields
    }

    @FXML
    void textFieldInput(ActionEvent event) {
        System.out.println("cos sie stalo dokladnie to to"+ textInput.getText());
    }

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

}

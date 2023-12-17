package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AboutWindowController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void backToMenuButton(ActionEvent event) throws IOException {
        System.out.println("back to main");
        new SceneSwitch(anchorPane, "MainWindow.fxml");
    }

}

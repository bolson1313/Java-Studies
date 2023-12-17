package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.Objects;

public class MainWindowController {

    @FXML
    private AnchorPane menuScene;

    @FXML
    void exitButton(ActionEvent event) {
        System.out.println("byebye!");
        System.exit(1);
    }

    @FXML
    void stiwtchToAbout(ActionEvent event) throws IOException {
        System.out.println("about window");
        new SceneSwitch(menuScene, "AboutWindow.fxml");
    }

    @FXML
    void switchToStart(ActionEvent event) throws IOException {
        System.out.println("start");
        new SceneSwitch(menuScene, "GameWindow.fxml");
    }

    @FXML
    void switchToStats(ActionEvent event) {
        System.out.println("stats");
    } // tutaj jakas baza danych w wszystkimi wynikami :)5

}

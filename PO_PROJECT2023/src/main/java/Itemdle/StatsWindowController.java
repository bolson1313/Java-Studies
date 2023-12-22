package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StatsWindowController {

    @FXML
    private AnchorPane mainStatsPane;
    @FXML
    private TableView<Stats> tableView = new TableView<Stats>();
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        System.out.println("back to main window");
        new SceneSwitch(mainStatsPane, "MainWindow.fxml");
    }

    @FXML
    void exitButton(ActionEvent event) {
        System.out.println("byebye!");
        System.exit(1);
    }

}
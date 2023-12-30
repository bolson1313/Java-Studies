package Itemdle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class StatsWindowController implements Initializable {

    @FXML
    private AnchorPane mainStatsPane;
    @FXML
    private TableView<StatsEntity> tableView = new TableView<StatsEntity>();
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

    private final ObservableList<StatsEntity> data = FXCollections.observableList(new DBexecute().getStatsToList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<StatsEntity, Integer> idCol = new TableColumn<>("Game ID");
        idCol.setPrefWidth(70);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setEditable(false);

        TableColumn<StatsEntity, String> nameCol = new TableColumn<>("Guessed Item");
        nameCol.setPrefWidth(403);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        nameCol.setEditable(false);

        TableColumn<StatsEntity, Integer> triesCol = new TableColumn<>("Number of Tries");
        triesCol.setPrefWidth(166);
        triesCol.setCellValueFactory(new PropertyValueFactory<>("tries"));
        triesCol.setEditable(false);

        TableColumn<StatsEntity, LocalDateTime> dateCol = new TableColumn<>("Date of the Game");
        dateCol.setPrefWidth(243);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("datetime"));
        dateCol.setEditable(false);

        tableView.setItems(data);
        tableView.getColumns().addAll(idCol, nameCol, triesCol, dateCol);
        System.out.println(data);
    }
}
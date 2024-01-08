package Itemdle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;

public class StatsWindowController implements Initializable {

    @FXML
    private AnchorPane mainStatsPane;
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        //System.out.println("back to main window");
        new SceneSwitch(mainStatsPane, "MainWindow.fxml");
    }
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    @FXML
    void exitButton(ActionEvent event) {
        //System.out.println("byebye!");
        System.exit(1);
    }

    @FXML
    private AnchorPane tableViewPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add("Played Games");
        choiceBox.getItems().add("Items");
        //statsTableView.setVisible(false);
        choiceBox.setOnAction((event) -> {
                int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
                Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();
                System.out.println("index: "+selectedIndex+" item: "+selectedItem);
                switch (selectedIndex){
                    case 0:
                        tableViewPane.getChildren().clear();
                        statView();
                        break;
                    case 1:
                        tableViewPane.getChildren().clear();
                        itemView();
                        break;
                    default:
                        tableViewPane.getChildren().clear();
                        break;
                }
        });
    }

    private void statView(){
        TableView<StatsEntity> statsTableView = new TableView<>();
        statsTableView.setPrefWidth(884);
        statsTableView.setPrefHeight(466);
        statsTableView.setId("tableView");
        statsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<StatsEntity> dataStats = FXCollections.observableList(new DataBase().getStatsToList());

        TableColumn<StatsEntity, Integer> idCol = new TableColumn<>("Game ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("stat_id"));

        TableColumn<StatsEntity, String> nameCol = new TableColumn<>("Guessed Item");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("guessed_item"));

        TableColumn<StatsEntity, String> item_idCol = new TableColumn<>("Guessed Item ID");
        item_idCol.setCellValueFactory(new PropertyValueFactory<>("fk_guessed_item_id"));

        TableColumn<StatsEntity, Integer> triesCol = new TableColumn<>("Number of Tries");
        triesCol.setCellValueFactory(new PropertyValueFactory<>("tries"));

        TableColumn<StatsEntity, LocalDateTime> dateCol = new TableColumn<>("Date of the Game");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        statsTableView.setItems(dataStats);
        statsTableView.getColumns().addAll(idCol, nameCol, item_idCol, triesCol, dateCol);
        tableViewPane.getChildren().add(statsTableView);
    }
    private void itemView(){
        TableView<ItemsEntity> itemsTableView = new TableView<>();
        itemsTableView.setEditable(true);
        itemsTableView.setPrefWidth(884);
        itemsTableView.setPrefHeight(466);
        itemsTableView.setId("tableView");
        itemsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<ItemsEntity> dataItems = FXCollections.observableList(new DataBase().getEntityToList());

        TableColumn<ItemsEntity, Integer> itemIDCol = new TableColumn<>("Item ID");
        itemIDCol.setCellValueFactory(new PropertyValueFactory<>("item_id"));

        TableColumn<ItemsEntity, String> imgSrcCol = new TableColumn<>("Icon Source");
        imgSrcCol.setCellValueFactory(new PropertyValueFactory<>("img_src"));

        TableColumn<ItemsEntity, String> itemNameCol = new TableColumn<>("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        itemNameCol.setEditable(true);


        TableColumn<ItemsEntity, String> userCol = new TableColumn<>("User(s) of the item");
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TableColumn<ItemsEntity, String> tagCol = new TableColumn<>("Tag of the item");
        tagCol.setCellValueFactory(new PropertyValueFactory<>("tag"));

        TableColumn<ItemsEntity, String> effectCol = new TableColumn<>("Effect");
        effectCol.setCellValueFactory(new PropertyValueFactory<>("effect"));

        TableColumn<ItemsEntity, String> qualityCol = new TableColumn<>("Quality of the item");
        qualityCol.setCellValueFactory(new PropertyValueFactory<>("quality"));

        TableColumn<ItemsEntity, Integer> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<ItemsEntity, Boolean> buyCol = new TableColumn<>("Buyable");
        buyCol.setCellValueFactory(new PropertyValueFactory<>("buyable"));

        TableColumn<ItemsEntity, Boolean> upgradeCol = new TableColumn<>("Upgradeable");
        upgradeCol.setCellValueFactory(new PropertyValueFactory<>("upgrade"));

        itemsTableView.setItems(dataItems);
        itemsTableView.getColumns().addAll(itemIDCol, itemNameCol, userCol, tagCol, effectCol, qualityCol, priceCol, buyCol, upgradeCol);
        tableViewPane.getChildren().add(itemsTableView);
    }
}
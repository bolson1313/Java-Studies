package Itemdle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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

    private boolean buttonValidate = false;

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
                        buttonValidate = true;
                        tableViewPane.getChildren().clear();
                        statView();
                        break;
                    case 1:
                        buttonValidate = false;
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
        statsTableView.setPrefHeight(423);
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
        itemsTableView.setPrefHeight(423);
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
        itemNameCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setName(event.getNewValue());
            new DataBase().updateItem(item);
        });
        itemNameCol.setEditable(true);

        TableColumn<ItemsEntity, String> userCol = new TableColumn<>("User(s) of the item");
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        userCol.setCellFactory(TextFieldTableCell.forTableColumn());
        userCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setUser(event.getNewValue());
            new DataBase().updateItem(item);
        });
        userCol.setEditable(true);

        TableColumn<ItemsEntity, String> tagCol = new TableColumn<>("Tag of the item");
        tagCol.setCellValueFactory(new PropertyValueFactory<>("tag"));
        tagCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tagCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setTag(event.getNewValue());
            new DataBase().updateItem(item);
        });
        tagCol.setEditable(true);

        TableColumn<ItemsEntity, String> effectCol = new TableColumn<>("Effect");
        effectCol.setCellValueFactory(new PropertyValueFactory<>("effect"));
        effectCol.setCellFactory(TextFieldTableCell.forTableColumn());
        effectCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setEffect(event.getNewValue());
            new DataBase().updateItem(item);
        });
        effectCol.setEditable(true);

        TableColumn<ItemsEntity, String> qualityCol = new TableColumn<>("Quality of the item");
        qualityCol.setCellValueFactory(new PropertyValueFactory<>("quality"));
        qualityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        qualityCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setQuality(event.getNewValue());
            new DataBase().updateItem(item);
        });
        qualityCol.setEditable(true);

        TableColumn<ItemsEntity, Integer> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setPrice(event.getNewValue());
            new DataBase().updateItem(item);
        });
        priceCol.setEditable(true);


        TableColumn<ItemsEntity, Boolean> buyCol = new TableColumn<>("Buyable");
        buyCol.setCellValueFactory(new PropertyValueFactory<>("buyable"));
        buyCol.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean object) {
                return object ? "true" : "false";
            }

            @Override
            public Boolean fromString(String string) {
                return "true".equalsIgnoreCase(string);
            }
        }, true, false)); // Tutaj podajemy listę możliwych wartości: true i false
        buyCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setBuyable(event.getNewValue());
            new DataBase().updateItem(item);
        });
        buyCol.setEditable(true);


        TableColumn<ItemsEntity, Boolean> upgradeCol = new TableColumn<>("Upgradeable");
        upgradeCol.setCellValueFactory(new PropertyValueFactory<>("upgrade"));
        upgradeCol.setCellFactory(ComboBoxTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean object) {
                return object ? "true" : "false";
            }

            @Override
            public Boolean fromString(String string) {
                return "true".equalsIgnoreCase(string);
            }
        }, true, false)); // Tutaj podajemy listę możliwych wartości: true i false
        upgradeCol.setOnEditCommit(event -> {
            ItemsEntity item = event.getRowValue();
            item.setUpgrade(event.getNewValue());
            new DataBase().updateItem(item);
        });
        upgradeCol.setEditable(true);


        itemsTableView.setItems(dataItems);
        itemsTableView.getColumns().addAll(itemIDCol, itemNameCol, userCol, tagCol, effectCol, qualityCol, priceCol, buyCol, upgradeCol);
        tableViewPane.getChildren().add(itemsTableView);
    }


    @FXML
    void menageDBbtn(ActionEvent event) throws IOException {
        if(!buttonValidate){
            new SceneSwitch(mainStatsPane, "MenageDB.fxml");
        }
    }
}
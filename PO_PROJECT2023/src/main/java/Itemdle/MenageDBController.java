package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenageDBController implements Initializable {
    @FXML
    private ChoiceBox<String> deleteChoiceBox = new ChoiceBox<>();

    @FXML
    private CheckBox BuyableInput;

    @FXML
    private TextField EffectInput;

    @FXML
    private TextField PriceInput;

    @FXML
    private TextField QualityInput;

    @FXML
    private TextField TagInput;

    @FXML
    private CheckBox UpgradeInput;

    @FXML
    private TextField UserInput;

    @FXML
    private TextField itemNameInput;
    @FXML
    private AnchorPane anchorPane;
    private static ArrayList<String> itemsList = new DataBase().getItemsToArray();
    @FXML
    void SubmitBtn(ActionEvent event) {

        if(iconName.isBlank()){
            showAlert("You didn't select any icon!");
        }
        else if(itemNameInput.getText().isEmpty()){
            showAlert("You didn't fill item name!");
        }
        else if(UserInput.getText().isEmpty()){
            showAlert("You didn't fill user!");
        }
        else if(TagInput.getText().isEmpty()){
            showAlert("You didn't fill tag!");
        }
        else if(EffectInput.getText().isEmpty()){
            showAlert("You didn't fill effect!");
        }
        else if(QualityInput.getText().isEmpty()){
            showAlert("You didn't fill quality!");
        }
        else if(PriceInput.getText().isEmpty()){
            showAlert("You didn't fill price!");
        }
        else if(itemsList.contains(itemNameInput.getText())){
            showAlert("Item with that name already exists!");
        } else {
            try{
                int price = Integer.parseInt(PriceInput.getText());
                ItemsEntity item = new ItemsEntity(iconName, itemNameInput.getText(), UserInput.getText(), TagInput.getText(), EffectInput.getText(), QualityInput.getText(), price, UpgradeInput.isSelected(), BuyableInput.isSelected());
                new DataBase().addItem(item);
                System.out.println("Debug item added: "+item);
            } catch (NumberFormatException e) {
                showAlert("Wrong price format!");
            }

        }

    }

    @FXML
    void addImageBtn(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Icon name");
        dialog.setHeaderText(null);
        dialog.setContentText("Fill this with itemname + .png/.jpg :");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(item_src -> {
            iconName = item_src;
            System.out.println("Item added: " + item_src);
            showAlert("If you want it to run correctly you should add your file into .jar file to 'images/itemIcons' with the same name as you gave.");
        });
    }

    @FXML
    void backToStats(ActionEvent event) throws IOException {
        new SceneSwitch(anchorPane, "StatsWindow.fxml");
    }

    @FXML
    void exitButton(ActionEvent event) {
        System.exit(1);
    }

    private static String iconName = "";

    private void showAlert(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> itemsList = new DataBase().getItemsToArray();
        deleteChoiceBox.getItems().addAll(itemsList);
        deleteChoiceBox.setOnAction((event) -> {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Are you sure you want to delete "+deleteChoiceBox.getSelectionModel().getSelectedItem()+" from DataBase?");
            alert.setContentText("It will be permamently removed.");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                int selectedIndex = deleteChoiceBox.getSelectionModel().getSelectedIndex();
                String selectedItem = deleteChoiceBox.getSelectionModel().getSelectedItem();
                System.out.println("index: "+selectedIndex+" item: "+selectedItem);
                new DataBase().deleteItemByName(selectedItem);
                deleteChoiceBox.getItems().clear();
                deleteChoiceBox.getItems().addAll(new DataBase().getItemsToArray());
            } else{
                showAlert("Then click another item!");
            }
        });
    }
}
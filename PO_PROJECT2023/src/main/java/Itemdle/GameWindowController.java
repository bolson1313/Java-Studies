package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class GameWindowController{

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
        addingHbox(textInput.getText());
    }
    @FXML
    void textSubmitByClick(ActionEvent event) {
        addingHbox(textInput.getText());
    }

// nie dziala  :c
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        String[] items = {"apple", "banana", "car"};
//        TextFields.bindAutoCompletion(textInput, items);
//    }

    private void addingHbox(String itemname){
        //hbox with item stats
        //odstepy miedzi komorkami 42px
        //paddnig boki 20px
        //razem 62 px
        HBox hbox = new HBox();
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(862);
        hbox.setMaxWidth(862);
        hbox.setSpacing(6);
        Insets insets = new Insets(0,10,0,10);
        hbox.setPadding(insets);


        //kolekcja dla nodow
        ArrayList<Node> nodeArrayList = new ArrayList<Node>();

        //ustawienie zdjecia przedmiotu
        ImageView imageView = new ImageView();
        Image itemImage = new Image("file:src/main/resources/images/itemsIcons/BansheesClaw.jpg");
        imageView.setImage(itemImage);
        imageView.setId("hboxCell");
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        nodeArrayList.add(imageView);

        //podpowiedz o nazwie itemu
        Tooltip tooltip = new Tooltip(itemname);
        Tooltip.install(imageView, tooltip);

        //users
        Label userLabel = new Label("Tank");
        userLabel.setId("hboxCell");
        userLabel.setPrefHeight(100);
        userLabel.setPrefWidth(100);
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setTextAlignment(TextAlignment.CENTER);
        nodeArrayList.add(userLabel);


        //tags
        Label tagLabel = new Label("MR, DMG, ARMOR");
        tagLabel.setId("hboxCell");
        tagLabel.setWrapText(true);
        tagLabel.setTextAlignment(TextAlignment.CENTER);
        tagLabel.setAlignment(Pos.CENTER);
        tagLabel.setPrefHeight(100);
        tagLabel.setPrefWidth(100);
        nodeArrayList.add(tagLabel);


        //effects
        Label effectLabel = new Label("Passive");
        effectLabel.setId("hboxCell");
        effectLabel.setTextAlignment(TextAlignment.CENTER);
        effectLabel.setAlignment(Pos.CENTER);
        effectLabel.setPrefHeight(100);
        effectLabel.setPrefWidth(100);
        nodeArrayList.add(effectLabel);

        //quality
        Label qualityLabel = new Label("Legendary");
        qualityLabel.setId("hboxCell");
        qualityLabel.setTextAlignment(TextAlignment.CENTER);
        qualityLabel.setAlignment(Pos.CENTER);
        qualityLabel.setPrefHeight(100);
        qualityLabel.setPrefWidth(100);
        nodeArrayList.add(qualityLabel);

        //price
        Label priceLabel = new Label("3600");
        priceLabel.setId("hboxCell");
        priceLabel.setTextAlignment(TextAlignment.CENTER);
        priceLabel.setAlignment(Pos.CENTER);
        priceLabel.setPrefHeight(100);
        priceLabel.setPrefWidth(100);
        nodeArrayList.add(priceLabel);

        //buyable
        Label buyLabel = new Label("YES!");
        buyLabel.setId("hboxCell");
        buyLabel.setTextAlignment(TextAlignment.CENTER);
        buyLabel.setAlignment(Pos.CENTER);
        buyLabel.setPrefHeight(100);
        buyLabel.setPrefWidth(100);
        nodeArrayList.add(buyLabel);

        //upgrade
        Label upgradeLabel = new Label("NO!");
        upgradeLabel.setId("hboxCell");
        upgradeLabel.setTextAlignment(TextAlignment.CENTER);
        upgradeLabel.setAlignment(Pos.CENTER);
        upgradeLabel.setPrefHeight(100);
        upgradeLabel.setPrefWidth(100);
        nodeArrayList.add(upgradeLabel);

        //kolekcja nodow

        //dodawanie elemtnow do hboxa i scrolla
        hbox.setId("hboxScroll");
        hbox.getChildren().addAll(nodeArrayList);



        paneInScroll.setPrefHeight(paneInScroll.getHeight()+100);
        paneInScroll.getChildren().addAll(hbox);
    }


}

package Itemdle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GameWindowController implements Initializable{

    private Stage stage;

    private static List<ItemsEntity> itemListEntity = null;

    private static ArrayList<String> itemsArray = new ArrayList<>();
    private static List<ItemsEntity> RandomItem = null;

    private static ArrayList<String> usedItems = new ArrayList<>();
    public GameWindowController(){
        if(itemsArray.isEmpty()){
            itemsArray = new DBexecute().getItemsToArray();
        }
        int randomIndex;
        Random random = new Random();
        randomIndex = random.nextInt(1, itemsArray.size());
        RandomItem = new DBexecute().getRandomItem(randomIndex);
        System.out.println("random: "+RandomItem.toString());
    }
    private static AutoCompletionBinding<String> autocompleteText;
    @FXML
    private AnchorPane anchorGamePane;

    @FXML
    private Button button;

    @FXML
    private TextField textInput;

    @FXML
    private FlowPane paneInScroll;

    @FXML
    private HBox namesHbox;

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
    void clearButton(ActionEvent event) {
        paneInScroll.getChildren().clear();
        itemsArray = new DBexecute().getItemsToArray();
        textInput.clear();
        autocompleteText.dispose();
        System.out.println("restart:" +itemsArray.toString());
        textInput.setDisable(false);
        usedItems = new ArrayList<>();
        int randomIndex;
        Random random = new Random();
        randomIndex = random.nextInt(1, itemsArray.size());
        RandomItem = new DBexecute().getRandomItem(randomIndex);
        System.out.println("random: "+RandomItem.toString());
        namesHbox.setVisible(true);
    }

    @FXML
    void submitButton(ActionEvent event) {
        addTextInput();
    }
    @FXML
    void textSubmitByClick(ActionEvent event) {
        addTextInput();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchorGamePane.setLayoutX(0);
        anchorGamePane.setLayoutY(0);
        autocompleteText = TextFields.bindAutoCompletion(textInput, itemsArray);
    }



    //blokada tych samych itemow i wygrana :)
    private void addingHbox(String itemname){
        HBox wonHbox = new HBox();
        itemListEntity = new DBexecute().getEntityToList(textInput.getText());
        if(itemListEntity.isEmpty()){
            System.out.println("puste");
            textInput.clear();
            addTextInput();
        }
        else if (!usedItems.contains(textInput.getText()) &&(!(itemListEntity.get(0).equals(RandomItem.get(0))))){
            textInput.setStyle("-fx-border: green;");
            usedItems.add(textInput.getText());
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
            ArrayList<Node> nodeArrayList = new ArrayList<>();

            //ustawienie zdjecia przedmiotu
            ImageView imageView = new ImageView();
            Image itemImage = new Image("file:src/main/resources/images/itemsIcons/"+itemListEntity.get(0).getImg_src());
            imageView.setImage(itemImage);
            imageView.setId("hboxCell");
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            nodeArrayList.add(imageView);

            //podpowiedz o nazwie itemu
            Tooltip tooltip = new Tooltip(itemname);
            Tooltip.install(imageView, tooltip);

            //users
            Label userLabel = new Label(itemListEntity.get(0).getUser());
            userLabel.setId("hboxCell");
            userLabel.setPrefHeight(100);
            userLabel.setPrefWidth(100);
            userLabel.setAlignment(Pos.CENTER);
            userLabel.setTextAlignment(TextAlignment.CENTER);
            userLabel.setWrapText(true);
            if(RandomItem.get(0).getUser().equals(itemListEntity.get(0).getUser()))
            {
                userLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                userLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(userLabel);


            //tags
            Label tagLabel = new Label(itemListEntity.get(0).getTag());
            tagLabel.setId("hboxCell");
            tagLabel.setWrapText(true);
            tagLabel.setTextAlignment(TextAlignment.CENTER);
            tagLabel.setAlignment(Pos.CENTER);
            tagLabel.setPrefHeight(100);
            tagLabel.setPrefWidth(100);
            tagLabel.setWrapText(true);
            if(RandomItem.get(0).getTag().equals(itemListEntity.get(0).getTag()))
            {
                tagLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                tagLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(tagLabel);


            //effects
            Label effectLabel = new Label(itemListEntity.get(0).getEffect());
            effectLabel.setId("hboxCell");
            effectLabel.setTextAlignment(TextAlignment.CENTER);
            effectLabel.setAlignment(Pos.CENTER);
            effectLabel.setPrefHeight(100);
            effectLabel.setPrefWidth(100);
            effectLabel.setWrapText(true);
            if(RandomItem.get(0).getEffect().equals(itemListEntity.get(0).getEffect()))
            {
                effectLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                effectLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(effectLabel);

            //quality
            Label qualityLabel = new Label(itemListEntity.get(0).getQuality());
            qualityLabel.setId("hboxCell");
            qualityLabel.setTextAlignment(TextAlignment.CENTER);
            qualityLabel.setAlignment(Pos.CENTER);
            qualityLabel.setPrefHeight(100);
            qualityLabel.setPrefWidth(100);
            qualityLabel.setWrapText(true);
            if(RandomItem.get(0).getQuality().equals(itemListEntity.get(0).getQuality()))
            {
                qualityLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                qualityLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(qualityLabel);

            //price
            Label priceLabel = new Label(String.valueOf(itemListEntity.get(0).getPrice()));
            priceLabel.setId("hboxCell");
            priceLabel.setTextAlignment(TextAlignment.CENTER);
            priceLabel.setAlignment(Pos.CENTER);
            priceLabel.setPrefHeight(100);
            priceLabel.setPrefWidth(100);
            priceLabel.setWrapText(true);
            if(RandomItem.get(0).getPrice() == itemListEntity.get(0).getPrice())
            {
                priceLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                priceLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(priceLabel);

            //buyable
            Label buyLabel = new Label();
            if(itemListEntity.get(0).isBuyable()){
                buyLabel.setText("YES!");

            } else {
                buyLabel.setText("NO!");
            }
            buyLabel.setId("hboxCell");
            buyLabel.setTextAlignment(TextAlignment.CENTER);
            buyLabel.setAlignment(Pos.CENTER);
            buyLabel.setPrefHeight(100);
            buyLabel.setPrefWidth(100);
            buyLabel.setWrapText(true);
            if(RandomItem.get(0).isBuyable() == itemListEntity.get(0).isBuyable())
            {
                buyLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                buyLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(buyLabel);


            //upgrade
            Label upgradeLabel = new Label();
            if(itemListEntity.get(0).isUpgrade()){
                upgradeLabel.setText("YES!");

            } else {
                upgradeLabel.setText("NO!");
            }
            upgradeLabel.setId("hboxCell");
            upgradeLabel.setTextAlignment(TextAlignment.CENTER);
            upgradeLabel.setAlignment(Pos.CENTER);
            upgradeLabel.setPrefHeight(100);
            upgradeLabel.setPrefWidth(100);
            upgradeLabel.setWrapText(true);
            if(RandomItem.get(0).isUpgrade() == itemListEntity.get(0).isUpgrade())
            {
                upgradeLabel.setStyle("-fx-background-color: #1ED53C");
            } else {
                upgradeLabel.setStyle("-fx-background-color: #FF3C00");
            }
            nodeArrayList.add(upgradeLabel);

            //kolekcja nodow

            //dodawanie elemtnow do hboxa i scrolla
            hbox.setId("hboxScroll");
            hbox.getChildren().addAll(nodeArrayList);



            paneInScroll.setPrefHeight(paneInScroll.getHeight()+100);
            paneInScroll.getChildren().addAll(hbox);
            wonHbox = hbox;
        }
        if(!itemListEntity.isEmpty() && itemListEntity.get(0).getName().equals(RandomItem.get(0).getName())){
            textInput.setDisable(true);
            paneInScroll.getChildren().clear();
            namesHbox.setVisible(false);
            Label wonLabel = new Label("You Guessed Correctly!");
            wonLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: yellow;");
            paneInScroll.getChildren().addAll(wonLabel, wonHbox);
        }

    }

    public void addTextInput(){
        if(!textInput.getText().isEmpty()){
            addingHbox(textInput.getText());
            itemsArray.remove(textInput.getText());
            System.out.println("itemsarray"+itemsArray.toString());
            textInput.clear();
            autocompleteText.dispose();
            autocompleteText = TextFields.bindAutoCompletion(textInput, itemsArray);
        } else{
            textInput.clear();
            textInput.setStyle("-fx-border-color: red;-fx-border-width: 2px;");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.playFromStart();
                pause.setOnFinished(actionEvent -> {textInput.setStyle("-fx-border-color: green;-fx-border-widht: 2px;");});
            //textInput.setDisable(true);
        }
    }



}

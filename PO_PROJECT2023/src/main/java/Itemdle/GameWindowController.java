package Itemdle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.util.Duration;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GameWindowController implements Initializable{

    private Stage stage;

    private static List<ItemsEntity> itemListEntity = null;

    private static ArrayList<String> itemsArray = new ArrayList<>();
    private static List<ItemsEntity> RandomItem = null;

    private static ArrayList<String> usedItems = new ArrayList<>();
    private static int NumberOfTries = 0;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static LocalDateTime dateTime;
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
        //clearing button
        paneInScroll.getChildren().clear();
        itemsArray = new DBexecute().getItemsToArray();

        //restarting textfields
        textInput.clear();
        autocompleteText.dispose();
        System.out.println("restart:" +itemsArray.toString());
        textInput.setDisable(false);
        usedItems = new ArrayList<>();
        int randomIndex;

        NumberOfTries = 0;
        //get random item into arraylist
        Random random = new Random();
        randomIndex = random.nextInt(1, itemsArray.size());
        RandomItem = new DBexecute().getRandomItem(randomIndex);
        System.out.println("random: "+RandomItem.toString());
        namesHbox.setVisible(true);
        autocompleteText = TextFields.bindAutoCompletion(textInput, itemsArray);
    }

    @FXML
    void submitButton(ActionEvent event) {
        addTextInput(textInput.getText());
    }
    @FXML
    void textSubmitByClick(ActionEvent event) {
        addTextInput(textInput.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize textfields
        anchorGamePane.setLayoutX(0);
        anchorGamePane.setLayoutY(0);
        autocompleteText = TextFields.bindAutoCompletion(textInput, itemsArray);
    }



    //blokada tych samych itemow i wygrana :)
    private void addingHbox(String itemname){
        //main hbox
        HBox wonHbox = new HBox();
        //get typed item into arraylist
        itemListEntity = new DBexecute().getEntityToList(textInput.getText());
        if(itemListEntity.isEmpty()){
            System.out.println("puste");
            textInput.clear();
            addTextInput(textInput.getText());
        }
        //validation
        else if (!usedItems.contains(textInput.getText()) &&(!(itemListEntity.get(0).equals(RandomItem.get(0))))){
            usedItems.add(textInput.getText());

            NumberOfTries++;
            textInput.clear();
            textInput.setStyle("-fx-border-color: green;-fx-border-width: 2px;");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.playFromStart();
            pause.setOnFinished(actionEvent -> {textInput.setStyle("");});
            System.out.println("used item: "+usedItems.toString());


            //hbox in scroll and flow pane
            HBox hbox = new HBox();
            hbox.setPrefHeight(100);
            hbox.setPrefWidth(862);
            hbox.setMaxWidth(862);
            hbox.setSpacing(6);
            Insets insets = new Insets(0,10,0,10);
            hbox.setPadding(insets);


            //collection for nodes
            ArrayList<Node> nodeArrayList = new ArrayList<>();

            //seting a imageview to item icon
            ImageView imageView = new ImageView();
            Image itemImage = new Image("file:src/main/resources/images/itemsIcons/"+itemListEntity.get(0).getImg_src());
            System.out.println("file:src/main/resources/images/itemsIcons/"+itemListEntity.get(0).getImg_src());
            imageView.setImage(itemImage);
            imageView.setId("hboxCell");
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            nodeArrayList.add(imageView);

            //hint if u hover on item icon it tells u the name of item u typed
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
            Label tagLabel = new Label(tagItem(itemListEntity.get(0).getTag()).toString());
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
            } else if(containsArrayListElements((RandomItem.get(0).getTag()) ,  tagsInArrayList(itemListEntity.get(0).getTag()))) {
                tagLabel.setStyle("-fx-background-color: #E28E2D");
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

            //node collection

            //adding all elements in into hbox
            hbox.setId("hboxScroll");
            hbox.getChildren().addAll(nodeArrayList);



            paneInScroll.setPrefHeight(paneInScroll.getHeight()+100);
            paneInScroll.getChildren().addAll(hbox);
            wonHbox = hbox;
        }
        //check if typed item is in db and if it fits random item then setdisable buttons
        if(!itemListEntity.isEmpty() && itemListEntity.get(0).getName().equals(RandomItem.get(0).getName())){
            textInput.setDisable(true);
            paneInScroll.getChildren().clear();
            namesHbox.setVisible(false);
            Label wonLabel = new Label("You Guessed Correctly!");
            wonLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: yellow;");

            dateTime = LocalDateTime.now();
            String formattedDateTime = dateTime.format(formatter);
            new DBexecute().insertStat(new Stats(itemListEntity.get(0).getName(), NumberOfTries, formattedDateTime));

            paneInScroll.getChildren().addAll(wonLabel, wonHbox);
        }

    }

    public void addTextInput(String input){
        //get input from textinput validation if empty change style wait 1s and set style back
        if(!textInput.getText().isEmpty()){
            addingHbox(textInput.getText());
            itemsArray.remove(input);
            System.out.println("itemsarray"+textInput.getText());
            textInput.clear();
            autocompleteText.dispose();
            autocompleteText = TextFields.bindAutoCompletion(textInput, itemsArray);
        } else{
            textInput.clear();
            textInput.setStyle("-fx-border-color: red;-fx-border-width: 2px;");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.playFromStart();
                pause.setOnFinished(actionEvent -> {textInput.setStyle("");});
        }
    }


    // get String to Array and then return arraylist with full tag names
    private ArrayList<String> tagItem(String input){
        ArrayList<String> tagsArray = new ArrayList<>();
        ArrayList<String> outputString = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] elements = input.split(",");

            tagsArray.addAll(Arrays.asList(elements));
        }
        for(String element : tagsArray) {
            switch (element) {
                case "AD":
                    outputString.add("Attack Damage");
                    break;
                case "AP":
                    outputString.add("Ability Power");
                    break;
                case "HP":
                    outputString.add("Health");
                    break;
                case "HPR":
                    outputString.add("Health Regeneration");
                    break;
                case "MREG":
                    outputString.add("Mana Regeneration");
                    break;
                case "MANA":
                    outputString.add("Mana");
                    break;
                default:
                    outputString.add("None");
                    break;
            }
        }
        return outputString;
    }

    // get String and then return it as arraylist element
    private ArrayList<String> tagsInArrayList(String input){
        ArrayList<String> tagsArray = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            // Dzieli wejściowy String na podstawie przecinka
            String[] elements = input.split(",");

            // Dodaje elementy do ArrayList
            tagsArray.addAll(Arrays.asList(elements));
        }
        return tagsArray;
    }


    //check if arraylist contains a String
    public static boolean containsArrayListElements(String input, ArrayList<String> arrayList) {
        for (String element : arrayList) {
            if (input.contains(element)) {
                return true;
            }
        }
        return false;
    }
}

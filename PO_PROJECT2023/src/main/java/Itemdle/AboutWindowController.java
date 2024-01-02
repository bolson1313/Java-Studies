package Itemdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutWindowController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView aboutImage;

    @FXML
    void backToMenuButton(ActionEvent event) throws IOException {
        //System.out.println("back to main");
        new SceneSwitch(anchorPane, "MainWindow.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Image image = new Image("file:src/main/resources/images/aboutimage.PNG");
        Image image = new Image(getClass().getResourceAsStream("/images/aboutimage.PNG"));
        aboutImage.setImage(image);
    }
}

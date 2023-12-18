package Itemdle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameWindow.fxml")));
        Scene mainScene = new Scene(root, Color.LIGHTBLUE);

        //style
        mainScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());



        //title and window icon
        stage.setTitle("League of Legends - Itemdle");
        Image Icon = new Image("windowicon.png");
        stage.getIcons().add(Icon);

        //window size
        stage.setWidth(1280);
        stage.setHeight(750);
        stage.setResizable(false);

        stage.setScene(mainScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


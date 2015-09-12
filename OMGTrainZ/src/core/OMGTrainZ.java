package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OMGTrainZ extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Engine engine = new Engine(primaryStage);
        ScreenManager.getInstance().setEngine(engine);
        ScreenManager.getInstance().setStage(primaryStage);
        engine.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

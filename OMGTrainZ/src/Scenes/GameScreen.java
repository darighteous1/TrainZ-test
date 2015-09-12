package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class GameScreen extends StackPane {

    // I want to create a separate class for each screen (Game and Menu for starters, later maybe Highscore screen)
    // but I am not sure if this is the correct way to do it
    // I decided to use singleton GameScreen to prevent resetting the game screen if i go to the menu screen and then back to the game screen
    // I am sure there is a better way to organize this but this is what came to my mind
    // My idea is that when you call the screen manager it creates or loads the respective screen (e.g. create a scene to be drawn)
    // or something like that. I got completely lost here.

    private static GameScreen instance;

    private StackPane layout;
    private Button button;
    private List<Image> drawables;

    private GameScreen() {
        this.layout = new StackPane();
        this.button = new Button("opsa");
        this.layout.getChildren().add(button);
        BuildGameScreen();
    }

    public static GameScreen getInstance() {
        if (instance == null) {
            instance = new GameScreen();
        }

        return instance;
    }

    private StackPane BuildGameScreen() {

        return this.layout;
    }


}

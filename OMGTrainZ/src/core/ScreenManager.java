package core;

import Scenes.GameScreen;
import Scenes.MenuScreen;
import Scenes.ScreenType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class ScreenManager {
    private static ScreenManager instance;

    private Stage stage;
    private Scene currentScene;
    private Engine engine;

    private ScreenManager() {
        currentScene = this.changeScreen(ScreenType.GAME);
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            return new ScreenManager();
        }

        return instance;
    }

    public Scene getCurrentScene() {
        return this.currentScene;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene changeScreen(ScreenType screenType) {
        switch (screenType) {
            case GAME:
                Button button = new Button("bum");
                StackPane layout = new StackPane();
                layout.getChildren().add(button);
                return new Scene(layout);
            case MENU:
                return new Scene(new MenuScreen());
//
//            // TODO: Add more screens later
//            case HIGHSCORE:
//                break;
//            case SPLASH:
//                break;
        }
        return null;
    }

}

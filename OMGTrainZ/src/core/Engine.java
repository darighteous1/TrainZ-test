package core;

import com.almasb.fxgl.asset.AssetManager;
import com.almasb.fxgl.asset.Assets;
import com.almasb.fxgl.util.FXGLLogger;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.logging.Level;

public class Engine implements Runnable {

    private boolean isRunning;
    private Assets assets;
    private Thread thread;
    private Stage window;

    public Engine(Stage window) {
        this.isRunning = false;
        this.window = window;
    }

    private void initialize() {

        FXGLLogger.init(Level.ALL);

        // TODO: implement initialization logic -> create game objects, set resolution etc.

        // I want to call here ScreenManager().getInstance().currentScene which should create new GameScreen and then set it
        // but it doesn't work so far. I am not sure if my approach is correct

        // This is here for test purposes
        Pane root = new Pane();
        root.setPrefSize(800, 600);

        // if uncommented this piece of code causes an Exception int thread "Thread-4" IllegalStateException: Not on FX application thread;
//        window.setScene(new Scene(root));
//        window.show();
    }

    private void loadContent() {
        try {
            this.assets = AssetManager.INSTANCE.cache();
            assets.logCached();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void update() {

    }

    private void draw() {

    }


    @Override
    public void run() {

        initialize();
        loadContent();

        //System.out.println(this.drawables);

        while (isRunning) {
            //TODO: calculate fps and remove thread sleep
            try {
                Thread.sleep(30);
                update();
                draw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        stop();
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }

        this.isRunning = true;
        this.thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }

        this.isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

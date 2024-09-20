package codythefennec;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private static Stage primaryStage;
    private AppScene appScene;

    // program window size
    private final double PROG_WIDTH = 1080;
    private final double PROG_HEIGHT = 768;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // initialize stage and boot program
        // figure font details later
        setPrimaryStage(primaryStage);
        MainApplication.primaryStage = primaryStage;
        primaryStage.setTitle("Broken Controller Video Viewer");
        primaryStage.show();
        appScene = new AppScene(this);

        // start at this scene
        setScene(appScene.fetchScene());
    }

    private void setScene(Scene sceneIn) {
        getPrimaryStage().setScene(sceneIn);
    }

    private void setPrimaryStage(Stage primaryStage) {
        MainApplication.primaryStage = primaryStage;
    }

    protected static Stage getPrimaryStage() {
        return primaryStage;
    }

    public double getPROG_WIDTH() {
        return PROG_WIDTH;
    }

    public double getPROG_HEIGHT() {
        return PROG_HEIGHT;
    }

    public void Launch(String[] args) {
        launch(args);
    }
}

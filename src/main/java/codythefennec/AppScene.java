package codythefennec;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class AppScene {
    private final MainApplication program;

    public AppScene(MainApplication program) {
        this.program = program;
    }

    // scene objects creation
    BorderPane mainPane;

    private Scene buildScene() {
        // init root node
        Group root = new Group();

        // initialize objects for setup
        return null;
    }

    public Scene fetchScene() {return buildScene();}
}

package codythefennec;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

        return new Scene(root,  program.getPROG_WIDTH(), program.getPROG_HEIGHT(), Color.WHITE);
    }

    public Scene fetchScene() {return buildScene();}
}

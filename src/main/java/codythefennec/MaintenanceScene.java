package codythefennec;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MaintenanceScene {
    private final MainApplication program;
    private final Stage stage;

    public MaintenanceScene(MainApplication program, Stage stage) {
        this.program = program;
        this.stage = stage;
    }

    // const colors
    private final Color bgGrey = Color.gray((double) 118 / 255);
    private final Color paleRed = Color.rgb(255, 169, 169);
    private final Color paleGreen = Color.rgb(169, 255, 169);
    private final Color paleYellow = Color.rgb(255, 255, 169);
    private final Color paleGrey = Color.rgb(169, 169, 169);

    // menu bools (can't add multiples)
    boolean addApplicationBool = false;
    boolean editApplicationBool = false;
    boolean removeApplicationBool = false;

    // scene objects creation
    BorderPane mainPane;

    // background
    Label titleLabel;

    Rectangle background;
    VBox buttonArea;
    Button openShowcase;
    Button addApplication;
    Button removeApplication;
    Button editApplication;
    HBox applicationArea;


    private Scene buildScene() {
        // init root node
        Group root = new Group();
        // initialize objects for setup

        // top label
        titleLabel = new Label("Maintenance Screen");
        titleLabel.setLayoutX(12);
        titleLabel.setLayoutY(6);

        // overlay with grey rectangle
        background = new Rectangle(0, 41, program.getPROG_WIDTH(), program.getPROG_HEIGHT() - 41);
        background.setFill(bgGrey);

        // add stuff to area for easy organization
        applicationArea = new HBox();
        applicationArea.setLayoutX(12);
        applicationArea.setLayoutY(57);
        applicationArea.setSpacing(20);

        // buttons
        buttonArea = new VBox();
        buttonArea.setMinHeight(182);
        buttonArea.setMaxWidth(306);

        openShowcase = new Button("Open Showcase");
        openShowcase.getStyleClass().add("button");

        addApplication = new Button("Add Application");
        addApplication.getStyleClass().add("button");
        addApplication.setOnAction(e -> {
            hideOpenMenus();

            if (!addApplicationBool) {
                System.out.println("Adding add menu");
                applicationArea.getChildren().add(openAddApplication());
                addApplicationBool = true;
            }
        });

        removeApplication = new Button("Remove Application");
        removeApplication.getStyleClass().add("button");
        removeApplication.setOnAction(e -> {
            hideOpenMenus();

            if (!removeApplicationBool) {
                System.out.println("Adding remove menu");
            }
        });

        editApplication = new Button("Edit Application");
        editApplication.getStyleClass().add("button");
        editApplication.setOnAction(e -> {
            hideOpenMenus();

            if (!editApplicationBool) {
                System.out.println("Adding edit menu");
            }
        });

        // add buttons
        buttonArea.getChildren().addAll(openShowcase, addApplication, removeApplication, editApplication);

        // add buttons to hbox for organization
        applicationArea.getChildren().add(buttonArea);

        // add everything to the root
        root.getChildren().addAll(background, titleLabel, applicationArea);

        // return the scene for the stage
        return new Scene(root,  program.getPROG_WIDTH(), program.getPROG_HEIGHT(), Color.WHITE);
    }

    private void hideOpenMenus() {
        // make sure that theres a menu actually open
        if (addApplicationBool || editApplicationBool || removeApplicationBool) {
            applicationArea.getChildren().remove(1);
        }

        // reset bool vars
        addApplicationBool = false;
        editApplicationBool = false;
        removeApplicationBool = false;
    }

    public VBox openRemoveApplication() {
        // init vbox
        VBox removeApplicationMenuVBox = new VBox();
        GridPane removeApplicationMenu = new GridPane();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        removeApplicationMenu.getRowConstraints().addAll(row0, row1, row2);
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        removeApplicationMenu.getColumnConstraints().addAll(col0, col1);
        removeApplicationMenu.setVgap(10);

        // add fields to the gridpane
        return removeApplicationMenuVBox;
    }

    public VBox openAddApplication() {
        VBox addApplicationMenuVBox = new VBox();
        GridPane addApplicationMenu = new GridPane();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        addApplicationMenu.getRowConstraints().addAll(row0, row1, row2);
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        addApplicationMenu.getColumnConstraints().addAll(col0, col1);
        addApplicationMenu.setVgap(10);

        Text applicationName = new Text("Application Name :\n(Maintenance Use)");
        addApplicationMenu.add(applicationName, 0, 0);

        TextArea applicationNameSubmit = new TextArea();
        applicationNameSubmit.setPromptText("Application Name..");
        applicationNameSubmit.setMaxHeight(70);
        addApplicationMenu.add(applicationNameSubmit, 1, 0);

        Text applicationLogo = new Text("Application Logo :");
        addApplicationMenu.add(applicationLogo, 0, 1);

        FileChooser applicationLogoSubmit = new FileChooser();
        applicationLogoSubmit.setTitle("Select Logo File");

        Button applicationLogoSubmitButton = new Button("Select Logo File..");
        final String[] logoFinalPath = new String[1];
        applicationLogoSubmitButton.setOnAction(e -> {
            File file = applicationLogoSubmit.showOpenDialog(stage);
            if (file != null) {
                logoFinalPath[0] = file.getPath();
            }
        });

        addApplicationMenu.add(applicationLogoSubmitButton, 1, 1);

        Text applicationDescription = new Text("Application Description :");
        addApplicationMenu.add(applicationDescription, 0, 2);

        TextArea applicationDescriptionInput = new TextArea();
        applicationDescriptionInput.setPromptText("Application Description..");
        applicationDescriptionInput.setWrapText(true);
        applicationDescriptionInput.minWidth(200);
        addApplicationMenu.add(applicationDescriptionInput, 1, 2);

        addApplicationMenuVBox.getChildren().add(addApplicationMenu);

        Button submitAddApplicationButton = new Button("Add Application");
        submitAddApplicationButton.setOnAction(e -> {
            System.out.println(applicationNameSubmit.getText());
            System.out.println(applicationDescriptionInput.getText());
            System.out.println(logoFinalPath[0]);
            // TODO Implement Data Structures
            hideOpenMenus();
        });

        addApplicationMenuVBox.getChildren().add(submitAddApplicationButton);

        return addApplicationMenuVBox;
    }

    public Scene fetchScene() {return buildScene();}

}

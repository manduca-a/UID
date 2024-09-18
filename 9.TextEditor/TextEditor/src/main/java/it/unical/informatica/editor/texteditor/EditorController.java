package it.unical.informatica.editor.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditorController {
    @FXML
    private Label welcomeText;

    @FXML
    private MenuItem New;
    @FXML
    private MenuItem Open;
    @FXML
    private MenuItem Save;
    @FXML
    private MenuItem Exit;
    @FXML
    private MenuItem About;
    @FXML
    private TabPane conte;

    @FXML
    Tab a = new Tab();
    TextArea t = new TextArea();

    @FXML
    protected void onNewClick() {
        conte.getTabs().add(new Tab("Untitled", t));
    }
    @FXML
    protected void onSaveClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onOpenClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onExitClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onAboutClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
package it.unical.demacs.informatica.Gestionale1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

    private static final SceneHandler instance = new SceneHandler();
    private Stage stage;
    private Scene scene;

    public static SceneHandler getInstance() {
        return instance;
    }

    private SceneHandler() {
    }

    public void init(Stage stage) {
        if (this.stage == null) {
            this.stage = stage;
            this.stage.setTitle("PRO-GEST");
            createLoginScene();
            this.stage.setScene(scene);
            this.stage.show();
        }
    }

    private <T> T loadRootFromFXML(String resourceName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneHandler.class.getResource(resourceName));
        return fxmlLoader.load();
    }

    public void createHomeScene() {
        try {
            scene.setRoot(loadRootFromFXML("home_page_view.fxml"));
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            stage.setWidth(400);
            stage.setHeight(400);
            stage.setResizable(true);
        } catch (IOException ignored) {
        }
    }

    public void createLoginScene() {
        try {
            if(scene == null)
                scene = new Scene(loadRootFromFXML("LoginForm.fxml"));
            else
                scene.setRoot(loadRootFromFXML("LoginForm.fxml"));
            stage.setMinWidth(350);
            stage.setMinHeight(400);
            stage.setWidth(350);
            stage.setHeight(450);
            stage.setResizable(false);
        } catch (IOException ignored) {
        }
    }

    public void createErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setContentText(message);
        alert.show();
    }
}

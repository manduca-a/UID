package it.unical.demacs.informatica.Gestionale1;

import it.unical.demacs.informatica.Gestionale1.view.SceneHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneHandler.getInstance().init(stage);
        SceneHandler.getInstance().createLoginScene();
    }

    public static void main(String[] args) {
        launch();
    }
}
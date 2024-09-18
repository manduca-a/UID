package it.unical.informatica.web;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Web extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Web.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 800);
        stage.setTitle("UID Web");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
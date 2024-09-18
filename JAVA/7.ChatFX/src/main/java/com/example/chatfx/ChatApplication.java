package com.example.chatfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("ChatView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(String.valueOf(ChatApplication.class.getResource("Sty.css")));
        stage.setTitle("ChatFrame");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
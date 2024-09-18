package it.unical.informatica.web;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Optional;

public class WebController {
    @FXML
    private MenuItem New;
    @FXML
    private MenuItem Exit;
    @FXML
    private MenuItem About;
    @FXML
    private TabPane conte;

    String tit = "Empty page";

    @FXML
    private Tab a;

    @FXML
    private TextField url;

    @FXML
    private Button go;

    @FXML
    private WebView wv;

    private WebEngine engine;

    @FXML
    private BorderPane primo;

    @FXML
    protected void onNewClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("web.fxml"));
        primo = loader.load();

        a = new Tab(tit,primo);
        conte.getTabs().add(a);
    }

    @FXML
    protected void onExitClick() {
        if (conte.getTabs().size()>0 && conte.getSelectionModel().getSelectedItem().getText()=="Untitled*"){
            var alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("File not saved. Are you sure you want to close?");
            alert.setResizable(false);
            Optional<ButtonType> result = alert.showAndWait();
            if(!result.isPresent()){}
            // alert is exited, no button has been pressed.
            else if(result.get() == ButtonType.OK){System.exit(3);}
            else if(result.get() == ButtonType.CANCEL){}
            // cancel button is pressed
        }
        else {
            var alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("Are you sure you want to close?");
            alert.setResizable(false);
            Optional<ButtonType> result = alert.showAndWait();
            if(!result.isPresent()){}
            // alert is exited, no button has been pressed.
            else if(result.get() == ButtonType.OK){System.exit(3);}
            else if(result.get() == ButtonType.CANCEL){}
            // cancel button is pressed
        }
    }

    @FXML
    protected void onAboutClick() {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Developed for User Interfaces Design!");

        alert.showAndWait();
    }

    @FXML
    protected void onGoClick() {
        conte.getSelectionModel().getSelectedItem().setText(url.getText());
        engine = wv.getEngine();
        engine.load("http://" + url.getText());
    }
}
package it.unical.demacs.informatica.Gestionale1.controller;

import it.unical.demacs.informatica.Gestionale1.model.AuthenticationHandler;
import it.unical.demacs.informatica.Gestionale1.view.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if(AuthenticationHandler.getInstance().login(username, password)) {
            SceneHandler.getInstance().createHomeScene();
        }
        else {
            SceneHandler.getInstance().createErrorMessage("Username o password errati");
        }
    }

    public void registrati(ActionEvent actionEvent) {
    }
}

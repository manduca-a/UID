package it.unical.demacs.informatica.Gestionale1.model;

public class AuthenticationHandler {

    private static AuthenticationHandler instance = new AuthenticationHandler();

    private AuthenticationHandler() {
    }

    public static AuthenticationHandler getInstance() {
        return instance;
    }

    public boolean login(String username, String password) {
        return "ciao".equals(username) && "ciao".equals(password);
    }
}

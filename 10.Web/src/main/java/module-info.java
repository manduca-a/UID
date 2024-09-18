module it.unical.informatica.editor.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens it.unical.informatica.web to javafx.fxml;
    exports it.unical.informatica.web;
}
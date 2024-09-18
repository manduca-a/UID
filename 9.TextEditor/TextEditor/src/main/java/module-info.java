module it.unical.informatica.editor.texteditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens it.unical.informatica.editor.texteditor to javafx.fxml;
    exports it.unical.informatica.editor.texteditor;
}
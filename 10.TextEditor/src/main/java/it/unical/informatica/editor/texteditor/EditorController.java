package it.unical.informatica.editor.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

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

    String tit = "Untitled*";

    @FXML
    private Tab a;

    @FXML
    private TextArea t;

    @FXML
    protected void onNewClick() {
        t = new TextArea();
        a = new Tab(tit,t);
        conte.getTabs().add(a);
    }
    @FXML
    protected void onSaveClick() throws IOException {
        if (conte.getTabs().size()>0) {

            FileChooser f = new FileChooser();
            f.setTitle("Save");
            f.setInitialFileName("Untitled-1.txt");
            f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text files", "*.txt"));
            File selected = f.showSaveDialog(null);

            if(selected!=null){
                conte.getSelectionModel().getSelectedItem().setText(selected.getName());
                Files.createFile(selected.toPath());
                BufferedWriter w = new BufferedWriter(new FileWriter(selected.getAbsoluteFile(), false));
                w.write(t.getText());
                w.close();
            }
        }
    }
    @FXML
    protected void onOpenClick() throws IOException {
        FileChooser f = new FileChooser();
        f.setTitle("Open");
        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File selected = f.showOpenDialog(null);
        t = new TextArea();
        BufferedReader br = new BufferedReader(new FileReader(selected.getAbsoluteFile()));
        if(selected!=null) {
            while (br.ready()) {
                String line = br.readLine();
                t.appendText(line);
            }
            a = new Tab(selected.getName(), t);
            conte.getTabs().add(a);
        }
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
}
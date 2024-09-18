package it.unical.demacs.informatica.Gestionale1.controller;

import it.unical.demacs.informatica.Gestionale1.model.Note;
import it.unical.demacs.informatica.Gestionale1.view.NotesManager;
import it.unical.demacs.informatica.Gestionale1.view.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePageController {

    @FXML
    private TableColumn<Note, String> dateColumn;

    @FXML
    private TableColumn<Note, String> descriptionColumn;

    @FXML
    private TableView<Note> tableView;

    @FXML
    private TableColumn<Note, String> titleColumn;

    @FXML
    void addNote(ActionEvent event) {
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        Note n = new Note(date, "Titolo1", "Description");
        NotesManager.getInstance().add(n);
        tableView.scrollTo(n);
    }

    @FXML
    void changedDescription(TableColumn.CellEditEvent event) {
        if(event.getRowValue() instanceof Note note) {
            if(event.getNewValue() instanceof String str)
                note.setDescription(str);
        }
    }

    @FXML
    void changedTitle(TableColumn.CellEditEvent event) {
        if(event.getRowValue() instanceof Note note) {
            if(event.getNewValue() instanceof String str)
                note.setTitle(str);
        }
    }

    @FXML
    void doLogout(ActionEvent event) {
        SceneHandler.getInstance().createLoginScene();
    }

    @FXML
    void initialize() {
        tableView.setItems(NotesManager.getInstance().getNotes());
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

}
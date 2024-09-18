package it.unical.demacs.informatica.Gestionale1.view;

import it.unical.demacs.informatica.Gestionale1.model.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NotesManager {

    private final ObservableList<Note> notes = FXCollections.observableArrayList();

    private final static NotesManager instance = new NotesManager();
    private NotesManager() {
    }

    public static NotesManager getInstance() {
        return instance;
    }

    public void add(Note note) {
        notes.add(note);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }
}

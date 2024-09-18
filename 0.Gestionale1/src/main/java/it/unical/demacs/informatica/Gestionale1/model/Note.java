package it.unical.demacs.informatica.Gestionale1.model;

public class Note {

    private String date;
    private String title;
    private String description;

    public Note(String date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return date + ";" + title + ";" + description;
    }
}

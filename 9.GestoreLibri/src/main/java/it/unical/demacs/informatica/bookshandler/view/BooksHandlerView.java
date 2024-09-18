package it.unical.demacs.informatica.bookshandler.view;

import it.unical.demacs.informatica.bookshandler.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BooksHandlerView {

    private final ObservableList<Book> books = FXCollections.observableArrayList();

    private final static BooksHandlerView instance = new BooksHandlerView();

    private BooksHandlerView() {
    }

    public static BooksHandlerView getInstance() {
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ObservableList<Book> getBooks() {
        return books;
    }
}

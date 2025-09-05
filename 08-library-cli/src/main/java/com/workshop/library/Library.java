package com.workshop.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book getBook(String bookName) {
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(bookName)) {
                return book;
            }
        }
        return null; // or throw an exception if preferred
    }
}

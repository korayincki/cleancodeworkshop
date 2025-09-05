package com.workshop.library;

import java.io.*;
import java.util.*;

public class Main {
    // Dirty: everything in main
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        while(true){
            System.out.print("cmd> ");
            String line = in.readLine();
            if(line==null || line.equals("quit")) break;
            if(line.startsWith("add ")){

                Book book = new Book(line.substring(4));
                library.addBook(book);
                System.out.println("added");

            } else if(line.equals("list")){

                List<Book> books = library.listBooks();
                for(Book b: books) System.out.println(b.getName());

            } else if(line.startsWith("find ")){
                String q = line.substring(5);

                Book book = library.getBook(q);

                if(book != null) {
                    System.out.println(book.getName());
                } else {
                    System.out.println("not found");
                }
            } else if(line.startsWith("remove ")){
                library.removeBook(library.getBook(line.substring(7)));
                System.out.println("removed");
            } else {
                System.out.println("unknown");
            }
        }
    }
}

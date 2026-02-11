package test;

import java.util.HashMap;
import java.util.Map;

// Book class to store book details
class Book {
    String bookName;
    String bookTitle;
    String author;

    Book(String bookName, String bookTitle, String author) {
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.author = author;
    }
}

// Library class that uses HashMap
class Library {
    Map<String, Book> books = new HashMap<>();

    // Add book
    void addBook(Book book) {
        books.put(book.bookName, book);
    }

    // Search book
    Book searchBook(String bookName) {
        return books.get(bookName);
    }

    // Remove book
    Book removeBook(String bookName) {
        return books.remove(bookName);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library  l1  = new Library();

        // Adding books
        l1.addBook(new Book("B1", "Atom", "James "));
        l1.addBook(new Book("B2", " Code", "Robert "));

        // Searching a book
        Book b = l1.searchBook("B2");
        if (b != null) {
            System.out.println("Book Name: " + b.bookName);
            System.out.println("Title: " + b.bookTitle);
            System.out.println("Author: " + b.author);
        } else {
            System.out.println("Book not found");
        }

        // Removing a book
        Book removed = l1.removeBook("B1");
        if (removed != null) {
            System.out.println("Removed book: " + removed.bookName);
        } else {
            System.out.println("Book not found");
        }
    }
}
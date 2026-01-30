package umlDigramCode;

import java.util.ArrayList;
import java.util.List;

// Book can exist independently (outside any Library).
class Book {
    private String title;
    private final String author;

    // Constructor to create a Book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters (Library may use these to display details)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Helpful for printing book details directly
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

// Library aggregates Book objects (it stores references to books, does not own them).
class Library {
     String name;
     List<Book> books; // Aggregation: List holds Book references

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add an existing Book to this library
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    // Display all books available in this library
    public void displayBooks() {
        System.out.println("Library: " + name);

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println();
    }
}


public class libBooks {
    public static void main(String[] args) {

        // Books created independently (not inside any library)
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("Dune", "Frank Herbert");
        Book b3 = new Book("Atomic Habits", "James Clear");

        // Two different libraries
        Library cityLibrary = new Library("City Library");
        Library collegeLibrary = new Library("College Library");

        // Aggregation demonstration:
        // same Book object can be added to multiple libraries
        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        collegeLibrary.addBook(b1); // shared book (b1 exists independently)
        collegeLibrary.addBook(b3);

        // Display books in both libraries
        cityLibrary.displayBooks();
        collegeLibrary.displayBooks();

        // Proof that Book exists independently
        System.out.println("Independent book object still exists: " + b2);
    }
}

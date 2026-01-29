package staticFinalConcepts;

public class LibManagementSystem {

    static String libraryName = "City Central Library";

    private final String isbn;   // final: cannot be changed
    private String title;
    private String author;

    /*
     * Class: LibManagementSystem
     * Purpose: Demonstrates static, this, final, instanceof
     */
    public LibManagementSystem(String title, String author, String isbn) {
        this.title = title;     // this resolves ambiguity
        this.author = author;
        this.isbn = isbn;       // final assigned once
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void safeDisplay(Object obj) {
        if (obj instanceof LibManagementSystem) {   // instanceof check
            ((LibManagementSystem) obj).displayDetails();
        } else {
            System.out.println("Not a Book object.");
        }
    }

    public static void main(String[] args) {
        LibManagementSystem b1 =
                new LibManagementSystem("Atomic Habits", "James Clear", "9780735211292");

        LibManagementSystem b2 =
                new LibManagementSystem("Clean Code", "Robert C. Martin", "9780132350884");

        displayLibraryName();

        safeDisplay(b1);
        System.out.println();
        safeDisplay(b2);
        System.out.println();
        safeDisplay("Hello");
    }
}

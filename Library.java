
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getId() == book.getId()) {
                throw new IllegalArgumentException(
                    "Book ID already exists!"
                );
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n----- BOOK LIST -----");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search book by ID
    public Book searchBook(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        throw new IllegalArgumentException(
            "Book not found!"
        );
    }

    // Borrow a book
    public void borrowBook(int id) {

        Book book = searchBook(id);

        if (!book.isAvailable()) {
            throw new IllegalStateException(
                "Book is already borrowed!"
            );
        }

        book.borrowBook();

        System.out.println("Book borrowed successfully!");
    }

    // Return a book
    public void returnBook(int id) {

        Book book = searchBook(id);

        if (book.isAvailable()) {
            throw new IllegalStateException(
                "This book was not borrowed!"
            );
        }

        book.returnBook();

        System.out.println("Book returned successfully!");
    }

    // Search books by title or author
    public void searchByName(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())
                || book.getAuthor().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }
}

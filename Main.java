
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Library library = new Library();

    int choice = 0;

    System.out.println("================================");
    System.out.println("   LIBRARY MANAGEMENT SYSTEM");
    System.out.println("================================");

    do {
        System.out.println("\n1. Add Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Search Book by Name");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

        System.out.print("\nEnter your choice: ");

        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            continue;
        }

        try {
            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    if (title.trim().isEmpty() ||
                        author.trim().isEmpty()) {
                        throw new IllegalArgumentException(
                            "Title and author cannot be empty!");
                    }

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    System.out.println(library.searchBook(searchId));
                    break;

                case 4:
                    System.out.print("Enter Title or Author: ");
                    String keyword = sc.nextLine();
                    library.searchByName(keyword);
                    break;

                case 5:
                    System.out.print("Enter Book ID to Borrow: ");
                    int borrowId = Integer.parseInt(sc.nextLine());
                    library.borrowBook(borrowId);
                    break;

                case 6:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = Integer.parseInt(sc.nextLine());
                    library.returnBook(returnId);
                    break;

                case 7:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");

        } catch (IllegalArgumentException |
                 IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    } while (choice != 7);

    sc.close();
}


class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {

    private BookNode head = null;
    private BookNode tail = null;
    private int size = 0;

    // Add at beginning
    public void addAtBeginning(BookNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // Add at end
    public void addAtEnd(BookNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // Add at specific position
    public void addAtPosition(BookNode node, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addAtBeginning(node);
            return;
        }

        if (pos == size) {
            addAtEnd(node);
            return;
        }

        BookNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    // Remove by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        BookNode temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        size--;
        System.out.println("Book removed successfully");
    }

    // Search by Title or Author
    public void searchBook(String keyword) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println(
                    "ID: " + temp.bookId +
                    ", Title: " + temp.title +
                    ", Author: " + temp.author +
                    ", Genre: " + temp.genre +
                    ", Available: " + (temp.isAvailable ? "Yes" : "No")
                );
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    // Update availability
    public void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books available");
            return;
        }

        BookNode temp = head;
        while (temp != null) {
            System.out.println(
                "ID: " + temp.bookId +
                ", Title: " + temp.title +
                ", Author: " + temp.author +
                ", Genre: " + temp.genre +
                ", Available: " + (temp.isAvailable ? "Yes" : "No")
            );
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available");
            return;
        }

        BookNode temp = tail;
        while (temp != null) {
            System.out.println(
                "ID: " + temp.bookId +
                ", Title: " + temp.title +
                ", Author: " + temp.author +
                ", Genre: " + temp.genre +
                ", Available: " + (temp.isAvailable ? "Yes" : "No")
            );
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        return size;
    }

    // Demo / main method
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addAtEnd(new BookNode(101, "The Alchemist", "Paulo Coelho", "Fiction", true));
        library.addAtEnd(new BookNode(102, "1984", "George Orwell", "Dystopian", true));
        library.addAtBeginning(new BookNode(103, "Sapiens", "Yuval Harari", "History", true));
        library.addAtPosition(new BookNode(104, "Clean Code", "Robert Martin", "Programming", true), 2);

        System.out.println("Library Forward:");
        library.displayForward();

        System.out.println("\nLibrary Reverse:");
        library.displayReverse();

        System.out.println("\nSearching for '1984':");
        library.searchBook("1984");

        System.out.println("\nUpdating availability of Book ID 102 to false:");
        library.updateAvailability(102, false);

        System.out.println("\nLibrary Forward after update:");
        library.displayForward();

        System.out.println("\nRemoving Book ID 103:");
        library.removeByBookId(103);

        System.out.println("\nTotal books in library: " + library.countBooks());

        System.out.println("\nFinal Library:");
        library.displayForward();
    }
}


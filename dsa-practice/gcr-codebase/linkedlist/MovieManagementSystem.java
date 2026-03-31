// Use of doubly linked list 
class MovieNode {
    String title;
    String director;
    int year;
    int rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, int rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}


public class MovieManagementSystem {

    public static MovieNode head = null;
    public static MovieNode tail = null;
    int size = 0;

    // Add at beginning
    public void addAtBeginning(MovieNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // Add at ending
    public void addAtEnding(MovieNode node) {
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
    public void addAtSpecificPosition(MovieNode node, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addAtBeginning(node);
            return;
        }

        if (pos == size) {
            addAtEnding(node);
            return;
        }

        MovieNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    // Delete by movie title
    public void deleteByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        MovieNode temp = head;

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;
    }

    // Search by Director or Rating
    public void searchByDirectorOrRating(String director, int rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println(temp.title + " | " + temp.director +
                        " | " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No matching movies found");
    }

    // Display forward
    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director +
                    " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director +
                    " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update rating by title
    public void updateRating(String title, int newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addAtEnding(new MovieNode("Inception", "Nolan", 2010, 9));
        mms.addAtBeginning(new MovieNode("Interstellar", "Nolan", 2014, 10));
        mms.addAtEnding(new MovieNode("Avatar", "Cameron", 2009, 8));

        System.out.println("Forward Display:");
        mms.displayForward();

        System.out.println("\nReverse Display:");
        mms.displayReverse();

        System.out.println("\nSearch (Director=Nolan OR Rating=8):");
        mms.searchByDirectorOrRating("Nolan", 8);

        mms.updateRating("Avatar", 9);

        System.out.println("\nAfter Update:");
        mms.displayForward();

        mms.deleteByTitle("Inception");

        System.out.println("\nAfter Deletion:");
        mms.displayForward();
    }
}

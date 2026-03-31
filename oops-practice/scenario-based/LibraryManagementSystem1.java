import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception for unavailable books
class BookNotAvailableException extends Exception{
    BookNotAvailableException(String message){
        super(message);
    }
}

// Book class to store book details
class Book{
    String title;
    String author;
    String status; // "Available" or "Checked Out"

    Book(String title,String author,String status){
        this.title=title;
        this.author=author;
        this.status=status;
    }
}

public class LibraryManagementSystem1{
    // Display all books
    public static void displayAllBooks(List<Book> bookList){
        System.out.println("\n--- All Books ---");
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            System.out.println((i+1)+". "+b.title+" by "+b.author+" ["+b.status+"]");
        }
    }

    // Display only available books
    public static void displayAvailableBooks(List<Book> bookList){
        System.out.println("\n--- Available Books ---");
        boolean found=false;
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(b.status.equals("Available")){
                System.out.println((i+1)+". "+b.title+" by "+b.author);
                found=true;
            }
        }
        if(!found) System.out.println("No books available");
    }

    // Search books by partial title
    public static void searchBookByTitle(List<Book> bookList,String term){
        System.out.println("\n--- Search Results ---");
        boolean found=false;
        for(Book b:bookList){
            if(b.title.toLowerCase().contains(term.toLowerCase())){
                System.out.println(b.title+" by "+b.author+" ["+b.status+"]");
                found=true;
            }
        }
        if(!found) System.out.println("No books found matching '"+term+"'");
    }

    // Checkout a book
    public static void checkoutBook(List<Book> bookList,int index) throws BookNotAvailableException{
        if(index<0 || index>=bookList.size()) return;
        Book b=bookList.get(index);
        if(b.status.equals("Checked Out")) throw new BookNotAvailableException("Book '"+b.title+"' is already checked out");
        b.status="Checked Out";
        System.out.println("Book '"+b.title+"' checked out successfully");
    }

    // Return a book
    public static void returnBook(List<Book> bookList,int index){
        if(index<0 || index>=bookList.size()) return;
        Book b=bookList.get(index);
        if(b.status.equals("Available")) System.out.println("Book '"+b.title+"' is already available");
        else{
            b.status="Available";
            System.out.println("Book '"+b.title+"' returned successfully");
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        // Store books in array
        Book[] books={
            new Book("The Great Gatsby","F. Scott Fitzgerald","Available"),
            new Book("To Kill a Mockingbird","Harper Lee","Available"),
            new Book("1984","George Orwell","Checked Out"),
            new Book("Pride and Prejudice","Jane Austen","Available"),
            new Book("The Catcher in the Rye","J.D. Salinger","Available")
        };

        // Transfer books to List
        List<Book> bookList=new ArrayList<>();
        for(Book b:books) bookList.add(b);

        while(true){
            System.out.println("\n=== Library Management ===");
            System.out.println("1. Display all books");
            System.out.println("2. Display available books");
            System.out.println("3. Search book by title");
            System.out.println("4. Checkout a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: displayAllBooks(bookList); break;
                case 2: displayAvailableBooks(bookList); break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String term=sc.nextLine();
                    searchBookByTitle(bookList,term);
                    break;
                case 4:
                    displayAllBooks(bookList);
                    System.out.print("Enter book number to checkout: ");
                    try{
                        int idx=sc.nextInt()-1;
                        checkoutBook(bookList,idx);
                    }catch(BookNotAvailableException e){
                        System.out.println("Exception: "+e.getMessage());
                    }
                    break;
                case 5:
                    displayAllBooks(bookList);
                    System.out.print("Enter book number to return: ");
                    int idx=sc.nextInt()-1;
                    returnBook(bookList,idx);
                    break;
                case 6: System.out.println("Exiting..."); sc.close(); return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}

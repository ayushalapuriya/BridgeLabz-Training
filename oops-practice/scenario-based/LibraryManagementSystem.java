import java.util.Scanner;

// Book class to store book details
class Book {
	String title;
	String author;
	String status; // "Available" or "Checked Out"
	
	public Book(String title,String author,String status) {
		this.title=title;
		this.author=author;
		this.status=status;
	}
}

public class LibraryManagementSystem {
	
	// Method to display all books
	public static void displayAllBooks(Book[]books) {
		System.out.println("\n--- Library Book Collection ---");
		for(int i=0;i<books.length;i++) {
			System.out.println((i+1)+". Title: "+books[i].title);
			System.out.println("   Author: "+books[i].author);
			System.out.println("   Status: "+books[i].status);
			System.out.println();
		}
	}
	
	// Method to search books by partial title
	public static void searchBookByTitle(Book[]books,String searchTerm) {
		System.out.println("\n--- Search Results ---");
		boolean found=false;
		for(int i=0;i<books.length;i++) {
			if(books[i].title.toLowerCase().contains(searchTerm.toLowerCase())) {
				System.out.println((i+1)+". Title: "+books[i].title);
				System.out.println("   Author: "+books[i].author);
				System.out.println("   Status: "+books[i].status);
				System.out.println();
				found=true;
			}
		}
		if(!found) {
			System.out.println("No books found matching '"+searchTerm+"'");
		}
	}
	
	// Method to checkout a book
	public static void checkoutBook(Book[]books,int bookIndex) {
		if(bookIndex<0 || bookIndex>=books.length) {
			System.out.println("Error: Invalid book number");
			return;
		}
		if(books[bookIndex].status.equals("Checked Out")) {
			System.out.println("Sorry! Book '"+books[bookIndex].title+"' is already checked out");
		} else {
			books[bookIndex].status="Checked Out";
			System.out.println("Success! Book '"+books[bookIndex].title+"' has been checked out");
		}
	}
	
	// Method to return a book
	public static void returnBook(Book[]books,int bookIndex) {
		if(bookIndex<0 || bookIndex>=books.length) {
			System.out.println("Error: Invalid book number");
			return;
		}
		if(books[bookIndex].status.equals("Available")) {
			System.out.println("Book '"+books[bookIndex].title+"' is already available");
		} else {
			books[bookIndex].status="Available";
			System.out.println("Success! Book '"+books[bookIndex].title+"' has been returned");
		}
	}
	
	// Method to display available books only
	public static void displayAvailableBooks(Book[]books) {
		System.out.println("\n--- Available Books ---");
		boolean found=false;
		for(int i=0;i<books.length;i++) {
			if(books[i].status.equals("Available")) {
				System.out.println((i+1)+". Title: "+books[i].title);
				System.out.println("   Author: "+books[i].author);
				System.out.println();
				found=true;
			}
		}
		if(!found) {
			System.out.println("No books are currently available");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Initialize library with sample books
		Book[]books=new Book[5];
		books[0]=new Book("The Great Gatsby","F. Scott Fitzgerald","Available");
		books[1]=new Book("To Kill a Mockingbird","Harper Lee","Available");
		books[2]=new Book("1984","George Orwell","Checked Out");
		books[3]=new Book("Pride and Prejudice","Jane Austen","Available");
		books[4]=new Book("The Catcher in the Rye","J.D. Salinger","Available");
		
		// Menu driven system
		while(true) {
			System.out.println("\n=== Library Management System ===");
			System.out.println("1. Display all books");
			System.out.println("2. Display available books");
			System.out.println("3. Search book by title");
			System.out.println("4. Checkout a book");
			System.out.println("5. Return a book");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			
			int choice=0;
			try {
				choice=sc.nextInt();
				sc.nextLine(); // Consume newline
			} catch(Exception e) {
				System.out.println("Error: Invalid input");
				sc.nextLine(); // Clear buffer
				continue;
			}
			
			switch(choice) {
				case 1:
					displayAllBooks(books);
					break;
				case 2:
					displayAvailableBooks(books);
					break;
				case 3:
					System.out.print("Enter title to search: ");
					String searchTerm=sc.nextLine();
					searchBookByTitle(books,searchTerm);
					break;
				case 4:
					displayAllBooks(books);
					System.out.print("Enter book number to checkout: ");
					try {
						int bookNum=sc.nextInt();
						checkoutBook(books,bookNum-1);
					} catch(Exception e) {
						System.out.println("Error: Invalid input");
						sc.nextLine();
					}
					break;
				case 5:
					displayAllBooks(books);
					System.out.print("Enter book number to return: ");
					try {
						int bookNum=sc.nextInt();
						returnBook(books,bookNum-1);
					} catch(Exception e) {
						System.out.println("Error: Invalid input");
						sc.nextLine();
					}
					break;
				case 6:
					System.out.println("Thank you for using Library Management System!");
					sc.close();
					return;
				default:
					System.out.println("Error: Invalid choice. Please select 1-6");
			}
		}
	}
}

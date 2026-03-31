
// Reservable interface - defines contract for reservation operations
interface Reservable{
	void reserveItem(String borrowerName);
	boolean checkAvailability();
}

// Abstract LibraryItem class
abstract class LibraryItem{
	private String itemId;
	private String title;
	private String author;
	
	// Setter for item id
	public void setItemId(String itemId) {
		this.itemId=itemId;
	}
	
	// Setter for title
	public void setTitle(String title) {
		this.title=title;
	}
	
	// Setter for author
	public void setAuthor(String author) {
		this.author=author;
	}
	
	// Getter for item id
	public String getItemId() {
		return this.itemId;
	}
	
	// Getter for title
	public String getTitle() {
		return this.title;
	}
	
	// Getter for author
	public String getAuthor() {
		return this.author;
	}
	
	LibraryItem(String itemId,String title,String author){
		setItemId(itemId);
		setTitle(title);
		setAuthor(author);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract int getLoanDuration();
	
	// Concrete method to display item details
	void getItemDetails() {
		System.out.println("Item ID: "+getItemId());
		System.out.println("Title: "+getTitle());
		System.out.println("Author: "+getAuthor());
	}
}

// Book class - implements Reservable interface
class Book extends LibraryItem implements Reservable{
	private String borrowerName;
	private boolean isAvailable;

	Book(String itemId,String title,String author){
		super(itemId,title,author);
		this.isAvailable=true;
	}
	
	@Override
	int getLoanDuration() {
		return 14;
	}	
	public void reserveItem(String borrowerName) {
		if(checkAvailability()) {
			this.borrowerName=borrowerName;
			this.isAvailable=false;
			System.out.println("Book reserved successfully for: "+borrowerName);
		}else {
			System.out.println("Book is already reserved!");
		}
	}
	public boolean checkAvailability() {
		return isAvailable;
	}
}

// Magazine class - implements Reservable interface
class Magazine extends LibraryItem implements Reservable{
	private String borrowerName;
	private boolean isAvailable;
	
	Magazine(String itemId,String title,String author){
		super(itemId,title,author);
		this.isAvailable=true;
	}
	
	@Override
	int getLoanDuration() {
		return 7;
	}
	public void reserveItem(String borrowerName) {
		if(checkAvailability()) {
			this.borrowerName=borrowerName;
			this.isAvailable=false;
			System.out.println("Magazine reserved successfully for: "+borrowerName);
		}else {
			System.out.println("Magazine is already reserved!");
		}
	}
	public boolean checkAvailability() {
		return isAvailable;
	}
}

// DVD class - implements Reservable interface
class DVD extends LibraryItem implements Reservable{
	private String borrowerName;
	private boolean isAvailable;
	
	DVD(String itemId,String title,String author){
		super(itemId,title,author);
		this.isAvailable=true;
	}
	
	@Override
	int getLoanDuration() {
		return 3;
	}
	public void reserveItem(String borrowerName) {
		if(checkAvailability()) {
			this.borrowerName=borrowerName;
			this.isAvailable=false;
			System.out.println("DVD reserved successfully for: "+borrowerName);
		}else {
			System.out.println("DVD is already reserved!");
		}
	}
	public boolean checkAvailability() {
		return isAvailable;
	}
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		// Creating library item objects
		Book book=new Book("B001","Java Programming","James Gosling");
		Magazine magazine=new Magazine("M001","Tech Monthly","Editorial Team");
		DVD dvd=new DVD("D001","Java Tutorial","Oracle");
		
		// Polymorphism: Processing library items using LibraryItem reference
		LibraryItem[] items={book,magazine,dvd};
		
		for(int i=0;i<items.length;i++) {
			System.out.println("Library Item "+(i+1)+":");
			items[i].getItemDetails();
			System.out.println("Loan Duration: "+items[i].getLoanDuration()+" days");
			
			// Access interface method using downcasting
			if(items[i] instanceof Reservable) {
				Reservable reservableItem=(Reservable)items[i];
				System.out.println("Available: "+reservableItem.checkAvailability());
				reservableItem.reserveItem("Ayush Kumar");
				System.out.println("Available after reservation: "+reservableItem.checkAvailability());
			}
			System.out.println();
		}
	}
}

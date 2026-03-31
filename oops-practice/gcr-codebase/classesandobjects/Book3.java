
public class Book3 {
	
	// Access modifiers
	public String ISBN;
	protected String title;
	private String author;
	
	// Constructor
	Book3(String ISBN,String title,String author){
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
	}
	
	// Public method to get author
	public String getAuthor(){
		return author;
	}
	
	// Public method to set author
	public void setAuthor(String author){
		this.author=author;
		System.out.println("Author updated to: "+author);
	}
	
	// Method to display book details
	public void display(){
		System.out.println("ISBN: "+ISBN);
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("--------------------------");
	}
}

// Subclass to demonstrate protected access
class EBook extends Book3{
	
	String fileFormat;
	double fileSize;
	
	// Constructor
	EBook(String ISBN,String title,String author,String fileFormat,double fileSize){
		super(ISBN,title,author);
		this.fileFormat=fileFormat;
		this.fileSize=fileSize;
	}
	
	// Method to display ebook details
	public void display(){
		System.out.println("ISBN: "+ISBN);
		System.out.println("Title: "+title);
		System.out.println("Author: "+getAuthor());
		System.out.println("File Format: "+fileFormat);
		System.out.println("File Size: "+fileSize+" MB");
		System.out.println("--------------------------");
	}
	
	// Method to demonstrate protected access
	public void displayProtectedTitle(){
		System.out.println("Accessing protected title from subclass: "+title);
	}
	
	public static void main(String[] args) {
		Book3 book=new Book3("978-0134685991","Effective Java","Joshua Bloch");
		System.out.println("Physical Book:");
		book.display();
		
		System.out.println("Accessing public member directly: "+book.ISBN);
		System.out.println("Accessing private member through getter: "+book.getAuthor());
		book.setAuthor("Joshua J. Bloch");
		System.out.println();
		
		EBook ebook=new EBook("978-0596009205","Head First Java","Kathy Sierra","PDF",5.2);
		System.out.println("Electronic Book:");
		ebook.display();
		ebook.displayProtectedTitle();
	}
}

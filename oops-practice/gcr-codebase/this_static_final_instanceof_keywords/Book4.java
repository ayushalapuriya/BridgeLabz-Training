
public class Book4 {
	
	// Static variable
	private static String libraryName="Egmore Library";
	
	// Instance variables
	private String title;
	private String author;
	
	// Final variable
	private final String isbn;
	
	// Constructor using this keyword
	Book4(String title,String author,String isbn){
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	
	// Static method to display library name
	static void displayLibraryName(){
		System.out.println("Library Name: "+libraryName);
	}
	
	// Method to display book details with instanceof check
	void display(Object obj){
		if(this instanceof Book4){
			Book4 book=(Book4)obj;
			System.out.println("Title: "+book.title);
			System.out.println("Author: "+book.author);
			System.out.println("ISBN: "+book.isbn);
		}else{
			System.out.println("Object is not an instance of Book4");
		}
	}
	
	public static void main(String[] args) {
		Book4 book=new Book4("Effective Java","Joshua Bloch","978-0134685991");
		
		Book4.displayLibraryName();
		book.display(book);
	}
}

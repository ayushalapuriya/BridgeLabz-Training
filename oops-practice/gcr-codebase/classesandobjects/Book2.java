
public class Book2 {
	
	// Attributes
	String title;
	String author;
	double price;
	boolean availability;
	
	// Constructor
	Book2(String title,String author,double price,boolean availability){
		this.title=title;
		this.author=author;
		this.price=price;
		this.availability=availability;
	}
	
	// Method to borrow book
	void borrowBook(){
		if(availability){
			availability=false;
			System.out.println("Book '"+title+"' has been borrowed successfully.");
		}else{
			System.out.println("Sorry, book '"+title+"' is not available.");
		}
	}
	
	// Method to return book
	void returnBook(){
		availability=true;
		System.out.println("Book '"+title+"' has been returned.");
	}
	
	// Method to display book details
	void display(){
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
		System.out.println("Availability: "+(availability?"Available":"Not Available"));
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		Book2 book1=new Book2("The Alchemist","Paulo Coelho",350.0,true);
		
		book1.display();
		book1.borrowBook();
		book1.display();
		book1.borrowBook();
		System.out.println();
		book1.returnBook();
		book1.display();
	}
}

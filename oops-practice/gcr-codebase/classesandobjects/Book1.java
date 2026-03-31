
public class Book1 {
	
	// Attributes
	String title;
	String author;
	double price;
	
	// Default constructor
	Book1(){
		this.title="Unknown";
		this.author="Unknown";
		this.price=0.0;
	}
	
	// Parameterized constructor
	Book1(String title,String author,double price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	
	// Method to display book details
	void display(){
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		Book1 book1=new Book1();
		Book1 book2=new Book1("Java Programming","James Gosling",850.0);
		
		book1.display();
		book2.display();
	}
}

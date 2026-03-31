
// Super class
class Book{
	String title;
	int publicationYear;
	Book(String title,int publicationYear){
		this.title=title;
		this.publicationYear=publicationYear;
	}
	void displayInfo() {
		System.out.println("Title: "+title);
		System.out.println("Publication Year: "+publicationYear);
		System.out.println();
	}
}

// Subclass Author - inherits from Book
class Author extends Book{
	String name;
	String bio;
	Author(String title,int publicationYear,String name,String bio){
		super(title,publicationYear);
		this.name=name;
		this.bio=bio;
	}
	// Method overriding
	void displayInfo() {
		System.out.println("Title: "+this.title);
		System.out.println("Publication Year: "+this.publicationYear);
		System.out.println("Name: "+this.name);
		System.out.println("Bio: "+this.bio);
		System.out.println();
	}
}

public class LibraryManagementWithBooksAndAuthors {
	public static void main(String[] args) {
		// Creating objects and demonstrating inheritance
		Book book=new Book("Story of two ox",1931);
		Author author=new Author("Story of two ox",1931,"Munsi Premchand","A Passionate Writter");
		
		System.out.println("Book Detail: ");
		book.displayInfo();
		System.out.println("Author Detail: ");
		author.displayInfo();
	}
}
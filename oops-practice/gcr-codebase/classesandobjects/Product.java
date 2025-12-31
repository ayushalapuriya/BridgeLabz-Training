
public class Product {
	
	// Instance variables
	String productName;
	double price;
	
	// Class variable
	static int totalProducts=0;
	
	// Constructor
	Product(String productName,double price){
		this.productName=productName;
		this.price=price;
		totalProducts++;
	}
	
	// Instance method to display product details
	void displayProductDetails(){
		System.out.println("Product Name: "+productName);
		System.out.println("Price: "+price);
		System.out.println("--------------------------");
	}
	
	// Class method to display total products
	static void displayTotalProducts(){
		System.out.println("Total Products Created: "+totalProducts);
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		Product product1=new Product("Laptop",45000.0);
		Product product2=new Product("Mouse",500.0);
		Product product3=new Product("Keyboard",1500.0);
		
		product1.displayProductDetails();
		product2.displayProductDetails();
		product3.displayProductDetails();
		
		Product.displayTotalProducts();
	}
}

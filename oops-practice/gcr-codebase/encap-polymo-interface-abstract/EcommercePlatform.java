
// Taxable interface - defines contract for tax operations
interface Taxable{
	double calculateTax();
	void getTaxDetails();
}

// Abstract Product class
abstract class Product{
	private String productId;
	private String name;
	private double price;
	
	// Setter for product id
	public void setProductId(String productId) {
		this.productId=productId;
	}
	
	// Setter for product name
	public void setName(String name) {
		this.name=name;
	}
	
	// Setter for product price
	public void setPrice(double price) {
		this.price=price;
	}
	
	// Getter for product id
	public String getProductId() {
		return this.productId;
	}
	
	// Getter for product name
	public String getName() {
		return this.name;
	}
	
	// Getter for product price
	public double getPrice() {
		return this.price;
	}
	
	Product(String productId,String name,double price){
		setProductId(productId);
		setName(name);
		setPrice(price);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateDiscount();
	
	// Concrete method to display product details
	void displayDetails() {
		System.out.println("Product Id: "+getProductId());
		System.out.println("Product Name: "+getName());
		System.out.println("Product Price: Rs."+getPrice());
	}
}

// Electronics class - implements Taxable interface
class Electronics extends Product implements Taxable{
	private double taxRate=0.18; // 18% GST for electronics
	
	Electronics(String productId,String name,double price){
		super(productId,name,price);
	}
	
	@Override
	double calculateDiscount() {
		return getPrice()*0.10; // 10% discount on electronics
	}
	
	@Override
	public double calculateTax() {
		return getPrice()*taxRate;
	}
	
	@Override
	public void getTaxDetails() {
		System.out.println("Tax Rate: "+(taxRate*100)+"% (Electronics GST)");
		System.out.println("Tax Amount: Rs."+calculateTax());
	}
}

// Clothing class - implements Taxable interface
class Clothing extends Product implements Taxable{
	private double taxRate=0.12; // 12% GST for clothing
	
	Clothing(String productId,String name,double price){
		super(productId,name,price);
	}
	
	@Override
	double calculateDiscount() {
		return getPrice()*0.20; // 20% discount on clothing
	}
	
	@Override
	public double calculateTax() {
		return getPrice()*taxRate;
	}
	
	@Override
	public void getTaxDetails() {
		System.out.println("Tax Rate: "+(taxRate*100)+"% (Clothing GST)");
		System.out.println("Tax Amount: Rs."+calculateTax());
	}
}

// Groceries class - implements Taxable interface
class Groceries extends Product implements Taxable{
	private double taxRate=0.05;
	
	Groceries(String productId,String name,double price){
		super(productId,name,price);
	}
	
	@Override
	double calculateDiscount() {
		return getPrice()*0.05;
	}
	
	@Override
	public double calculateTax() {
		return getPrice()*taxRate;
	}
	
	@Override
	public void getTaxDetails() {
		System.out.println("Tax Rate: "+(taxRate*100)+"% (Groceries GST)");
		System.out.println("Tax Amount: Rs."+calculateTax());
	}
}

public class EcommercePlatform {
	
	// Method to calculate and print final price for a product (Polymorphism)
	public static void calculateFinalPrice(Product product) {
		double originalPrice=product.getPrice();
		double discount=product.calculateDiscount();
		double tax=0;
		
		// Check if product is taxable
		if(product instanceof Taxable) {
			tax=((Taxable)product).calculateTax();
		}
		
		double finalPrice=originalPrice+tax-discount;
		
		System.out.println("Original Price: Rs."+originalPrice);
		System.out.println("Discount: Rs."+discount);
		System.out.println("Tax: Rs."+tax);
		System.out.println("Final Price: Rs."+finalPrice);
	}
	
	public static void main(String[] args) {
		// Creating product objects
		Electronics laptop=new Electronics("E001","Dell Laptop",50000);
		Clothing shirt=new Clothing("C001","Formal Shirt",2000);
		Groceries rice=new Groceries("G001","Basmati Rice",500);
		
		// Polymorphism: Processing products using Product reference
		Product[] products={laptop,shirt,rice};
		
		for(int i=0;i<products.length;i++) {
			System.out.println("Product "+(i+1)+":");
			products[i].displayDetails();
			System.out.println("Discount: Rs."+products[i].calculateDiscount());
			
			// Access interface method using downcasting
			if(products[i] instanceof Taxable) {
				((Taxable)products[i]).getTaxDetails();
			}
			
			calculateFinalPrice(products[i]);
			System.out.println();
		}
	}
}

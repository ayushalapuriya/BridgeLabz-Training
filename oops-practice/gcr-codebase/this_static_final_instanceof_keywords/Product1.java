
public class Product1 {
	
	// Static variable
	private static double discount=10.0;
	
	// Instance variables
	private String productName;
	private double price;
	private int quantity;
	
	// Final variable
	private final String productID;
	
	// Constructor using this keyword
	Product1(String productID,String productName,double price,int quantity){
		this.productID=productID;
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
	}
	
	// Static method to update discount
	public static void updateDiscount(double newDiscount){
		discount=newDiscount;
		System.out.println("Discount updated to: "+discount+"%");
	}
	
	// Method to calculate price after discount
	public double getPriceAfterDiscount(){
		double discountAmount=price*discount/100;
		return price-discountAmount;
	}
	
	// Method to display product details with instanceof check
	public void displayProductDetails(){
		if(this instanceof Product1){
			System.out.println("Product ID: "+productID);
			System.out.println("Product Name: "+productName);
			System.out.println("Price: $"+price);
			System.out.println("Quantity: "+quantity);
			System.out.println("Discount: "+discount+"%");
			System.out.println("Price after Discount: $"+getPriceAfterDiscount());
			System.out.println();
		}else{
			System.out.println("Object is not an instance of Product1");
		}
	}
	
	public static void main(String[] args) {
		Product1 product1=new Product1("P001","Laptop",1200.0,5);
		Product1 product2=new Product1("P002","Smartphone",800.0,10);
		
		product1.displayProductDetails();
		product2.displayProductDetails();
	}
}

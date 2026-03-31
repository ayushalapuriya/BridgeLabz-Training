
// Discountable interface - defines contract for discount operations
interface Discountable{
	double applyDiscount();
	void getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem{
	private String itemName;
	private double price;
	private int quantity;
	
	// Setter for item name
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}
	
	// Setter for price
	public void setPrice(double price) {
		this.price=price;
	}
	
	// Setter for quantity
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	// Getter for item name
	public String getItemName() {
		return this.itemName;
	}
	
	// Getter for price
	public double getPrice() {
		return this.price;
	}
	
	// Getter for quantity
	public int getQuantity() {
		return this.quantity;
	}
	
	FoodItem(String itemName,double price,int quantity){
		setItemName(itemName);
		setPrice(price);
		setQuantity(quantity);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateTotalPrice();
	
	// Concrete method to display item details
	void getItemDetails() {
		System.out.println("Item Name: "+getItemName());
		System.out.println("Price per item: Rs."+getPrice());
		System.out.println("Quantity: "+getQuantity());
	}
}

// VegItem class - implements Discountable interface
class VegItem extends FoodItem implements Discountable{
	private double discountRate=0.10;
	
	VegItem(String itemName,double price,int quantity){
		super(itemName,price,quantity);
	}
	
	@Override
	double calculateTotalPrice() {
		return getPrice()*getQuantity();
	}
	public double applyDiscount() {
		return calculateTotalPrice()*discountRate;
	}
	public void getDiscountDetails() {
		System.out.println("Discount Type: Veg Special");
		System.out.println("Discount Rate: "+(discountRate*100)+"%");
		System.out.println("Discount Amount: Rs."+applyDiscount());
	}
}

// NonVegItem class - implements Discountable interface
class NonVegItem extends FoodItem implements Discountable{
	private double additionalCharge=0.15;
	private double discountRate=0.05;
	
	NonVegItem(String itemName,double price,int quantity){
		super(itemName,price,quantity);
	}
	
	@Override
	double calculateTotalPrice() {
		double basePrice=getPrice()*getQuantity();
		double extraCharge=basePrice*additionalCharge;
		return basePrice+extraCharge;
	}
	public double applyDiscount() {
		return calculateTotalPrice()*discountRate;
	}
	public void getDiscountDetails() {
		System.out.println("Discount Type: Non-Veg Offer");
		System.out.println("Discount Rate: "+(discountRate*100)+"%");
		System.out.println("Discount Amount: Rs."+applyDiscount());
		System.out.println("Note: Non-Veg items have "+(additionalCharge*100)+"% additional charge");
	}
}

public class OnlineFoodDeliverySystem {
	public static void main(String[] args) {
		// Creating food item objects
		VegItem vegItem=new VegItem("Paneer Tikka",250,2);
		NonVegItem nonVegItem=new NonVegItem("Chicken Biryani",300,3);
		
		// Polymorphism: Processing food items using FoodItem reference
		FoodItem[] items={vegItem,nonVegItem};
		
		double totalOrderAmount=0;
		double totalDiscountAmount=0;
		
		for(int i=0;i<items.length;i++) {
			System.out.println("Food Item "+(i+1)+":");
			items[i].getItemDetails();
			double itemTotal=items[i].calculateTotalPrice();
			System.out.println("Total Price: Rs."+itemTotal);
			
			// Access interface method using downcasting
			if(items[i] instanceof Discountable) {
				Discountable discountableItem=(Discountable)items[i];
				discountableItem.getDiscountDetails();
				double discount=discountableItem.applyDiscount();
				totalDiscountAmount+=discount;
				System.out.println("Final Price after discount: Rs."+(itemTotal-discount));
			}
			
			totalOrderAmount+=itemTotal;
			System.out.println();
		}
		
		System.out.println("=".repeat(50));
		System.out.println("ORDER SUMMARY:");
		System.out.println("Total Order Amount: Rs."+totalOrderAmount);
		System.out.println("Total Discount: Rs."+totalDiscountAmount);
		System.out.println("Final Payable Amount: Rs."+(totalOrderAmount-totalDiscountAmount));
	}
}

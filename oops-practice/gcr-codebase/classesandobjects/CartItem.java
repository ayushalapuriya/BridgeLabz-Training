
public class CartItem {
	
	// Attributes
	String itemName;
	double price;
	int quantity;
	
	// Constructor
	CartItem(String itemName,double price,int quantity){
		this.itemName=itemName;
		this.price=price;
		this.quantity=quantity;
	}
	
	// Method to add item to cart
	void addItem(int count){
		quantity=quantity+count;
		System.out.println("Added "+count+" of "+itemName+" to the cart.");
	}
	
	// Method to remove item from cart
	void removeItem(int count){
		if(quantity>=count){
			quantity=quantity-count;
			System.out.println("Removed "+count+" of "+itemName+" from the cart.");
		}else{
			System.out.println("Not enough items to remove.");
		}
	}
	
	// Method to display total cost
	void displayTotalCost(){
		double totalCost=price*quantity;
		System.out.println("Total cost: $"+totalCost);
	}
	
	// Method to display item details
	void displayItem(){
		System.out.println("Item: "+itemName+", Price: $"+price+", Quantity: "+quantity);
	}
	
	public static void main(String[] args) {
		CartItem item=new CartItem("Laptop",999.99,1);
		
		item.displayItem();
		item.addItem(2);
		item.removeItem(1);
		item.displayTotalCost();
	}
}
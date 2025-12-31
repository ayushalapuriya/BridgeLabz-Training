
public class Item {
	
	// Attributes
	String itemCode;
	double price;
	String itemName;
	
	// Constructor
	Item(String itemCode,double price,String itemName){
		this.itemCode=itemCode;
		this.price=price;
		this.itemName=itemName;
	}
	
	// Display output
	void display(){
		System.out.println("itemCode : "+itemCode);
		System.out.println("itemPrice : "+price);
		System.out.println("itemName : "+itemName);
		System.out.println("----------------------------");
	}
	
	// Method to calculate total cost
	double calculateTotalCost(int quantity){
		double totalCost=price*quantity;
		return totalCost;
	}
	
	public static void main(String[] args) {
		Item item1=new Item("01AA",500.0,"Water bottle");
		Item item2=new Item("01BB",700.0,"Rice");
		Item item3=new Item("02AA",400.0,"blackboard");
		
		// Display all items
		item1.display();
		item2.display();
		item3.display();
		
		// Calculate total cost for given quantity
		int quantity1=3;
		int quantity2=5;
		int quantity3=2;
		
		double total1=item1.calculateTotalCost(quantity1);
		double total2=item2.calculateTotalCost(quantity2);
		double total3=item3.calculateTotalCost(quantity3);
		
		System.out.println("Total cost for "+quantity1+" "+item1.itemName+": "+total1);
		System.out.println("Total cost for "+quantity2+" "+item2.itemName+": "+total2);
		System.out.println("Total cost for "+quantity3+" "+item3.itemName+": "+total3);
	}
}
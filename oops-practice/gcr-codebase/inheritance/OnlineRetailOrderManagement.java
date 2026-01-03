
// Super class
class Order{
	String orderId;
	String orderDate;
	Order(String orderId,String orderDate){
		this.orderId=orderId;
		this.orderDate=orderDate;
	}
	String getOrderStatus(){
		return "Order Placed";
	}
	void displayOrderInfo(){
		System.out.println("Order ID: "+orderId);
		System.out.println("Order Date: "+orderDate);
		System.out.println("Status: "+getOrderStatus());
		System.out.println();
	}
}

// Subclass ShippedOrder - inherits from Order
class ShippedOrder extends Order{
	String trackingNumber;
	ShippedOrder(String orderId,String orderDate,String trackingNumber){
		super(orderId,orderDate);
		this.trackingNumber=trackingNumber;
	}
	// Method overriding
	String getOrderStatus(){
		return "Order Shipped";
	}
	// Method overriding
	void displayOrderInfo(){
		System.out.println("Order ID: "+orderId);
		System.out.println("Order Date: "+orderDate);
		System.out.println("Tracking Number: "+trackingNumber);
		System.out.println("Status: "+getOrderStatus());
		System.out.println();
	}
}

// Subclass DeliveredOrder - inherits from ShippedOrder (Multilevel Inheritance)
class DeliveredOrder extends ShippedOrder{
	String deliveryDate;
	DeliveredOrder(String orderId,String orderDate,String trackingNumber,String deliveryDate){
		super(orderId,orderDate,trackingNumber);
		this.deliveryDate=deliveryDate;
	}
	// Method overriding
	String getOrderStatus(){
		return "Order Delivered";
	}
	// Method overriding
	void displayOrderInfo(){
		System.out.println("Order ID: "+orderId);
		System.out.println("Order Date: "+orderDate);
		System.out.println("Tracking Number: "+trackingNumber);
		System.out.println("Delivery Date: "+deliveryDate);
		System.out.println("Status: "+getOrderStatus());
		System.out.println();
	}
}

public class OnlineRetailOrderManagement{
	public static void main(String[] args){
		// Creating objects and demonstrating multilevel inheritance
		Order order1=new Order("ORD001","2026-01-01");
		ShippedOrder order2=new ShippedOrder("ORD002","2026-01-02","TRK123456");
		DeliveredOrder order3=new DeliveredOrder("ORD003","2026-01-03","TRK789012","2026-01-05");
		
		System.out.println("=== Order Management System ===");
		System.out.println();
		
		order1.displayOrderInfo();
		order2.displayOrderInfo();
		order3.displayOrderInfo();
	}
}

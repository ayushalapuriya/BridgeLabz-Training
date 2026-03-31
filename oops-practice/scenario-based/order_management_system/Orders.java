package order_management_system;

import java.util.List;

public class Orders {
    private static int orderCounter = 1000;
    private int orderId;
    private List<Products> items;
    private double totalAmount;
    private String status;

    public Orders(List<Products> items, double totalAmount) {
        this.orderId = ++orderCounter;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = "Placed";
    }

    public int getOrderId() {
        return orderId;
    }

    public void cancelOrder() {
        status = "Cancelled";
        System.out.println("Order " + orderId + " has been cancelled.");
    }

    public void trackOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: " + status);
    }
}

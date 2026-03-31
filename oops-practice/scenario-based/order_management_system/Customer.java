package order_management_system;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String phoneNo;
    private List<Products> cart;
    private Orders order;

    public Customer(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.cart = new ArrayList<>();
    }

    public void browseProducts(List<Products> products) {
        System.out.println("Id\tName\tQuantity\tPrice");
        for (Products p : products) {
            System.out.println(p.getPId() + "\t" + p.getPName() + "\t" + p.getPQuantity() + "\t\t" + p.getPPrice());
        }
    }

    public void addToCart(Products p, int quantity) {
        if (p.getPQuantity() >= quantity) {
            cart.add(new Products(p.getPId(), p.getPName(), quantity, p.getPPrice()));
            p.setQuantity(p.getPQuantity() - quantity);
            System.out.println(quantity + " " + p.getPName() + "(s) added to cart.");
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Products p : cart) {
            total += p.getPQuantity() * p.getPPrice();
        }
        return total;
    }

    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose payment method (Card/UPI/Wallet): ");
        String method = sc.next();

        try {
            Payment payment;

            if (method.equalsIgnoreCase("Card")) {
                payment = new Card();
            } else if (method.equalsIgnoreCase("UPI")) {
                payment = new UPI();
            } else if (method.equalsIgnoreCase("Wallet")) {
                payment = new Wallet();
            } else {
                System.out.println("Invalid payment method.");
                return;
            }

            double totalAmount = calculateTotalAmount();
            payment.payAmount(totalAmount);

            order = new Orders(cart, totalAmount);
            System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
            cart = new ArrayList<>();

        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        if (order != null) {
            order.cancelOrder();
        } else {
            System.out.println("No active order to cancel.");
        }
    }

    public void trackOrder() {
        if (order != null) {
            order.trackOrder();
        } else {
            System.out.println("No order found.");
        }
    }
}

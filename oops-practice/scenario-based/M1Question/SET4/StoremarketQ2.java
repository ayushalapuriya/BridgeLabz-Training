package M1Question.SET4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Products {
    String name;
    double price;
    int quantity;

    Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract void display();
}

class Electronics extends Products {
    int warranty;

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    @Override
    public void display() {
        System.out.println("M1Question.SET4.Electronics: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty);
    }
}

class Clothing extends Products {
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("M1Question.SET4.Clothing: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
    }
}

class InventoryManagement {
    private List<Products> inventory = new ArrayList<>();

    public void addProduct(Products product) {
        inventory.add(product);
        System.out.println("Product added successfully");
    }

    public void displayInventory() {
        for (Products pr : inventory) {
            pr.display();
        }
    }

    public double totalPrice() {
        double total = 0;
        for (Products pr : inventory) {
            total += (pr.price * pr.quantity);
        }
        return total;
    }
}

public class StoremarketQ2 {
    public static void main(String[] args) {
        // We use the [Scanner](https://docs.oracle.com) class for input.
        Scanner sc = new Scanner(System.in);
        InventoryManagement im = new InventoryManagement();
        int t = sc.nextInt();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] arr = input.split(", ");
            if(arr[0].equals("M1Question.SET4.Electronics")){
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                int warranty = Integer.parseInt(arr[4]);
                Electronics e=new Electronics(name, price, quantity, warranty);
                im.addProduct(e);
            }
            else{
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String size = arr[4];
                Clothing c= new Clothing(name, price, quantity, size);
                im.addProduct(c);
            }
        }
        im.displayInventory();
        System.out.println("Total Price: " + im.totalPrice());
        sc.close();
    }
}

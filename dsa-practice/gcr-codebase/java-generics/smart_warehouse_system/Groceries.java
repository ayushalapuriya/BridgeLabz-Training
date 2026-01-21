package smart_warehouse_system;

public class Groceries extends WarehouseItem {
    private int quantity;

    public Groceries(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Quantity: " + quantity);
    }
}

package smart_warehouse_system;

public class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}
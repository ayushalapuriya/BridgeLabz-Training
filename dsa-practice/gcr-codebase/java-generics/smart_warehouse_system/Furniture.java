package smart_warehouse_system;

public class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}
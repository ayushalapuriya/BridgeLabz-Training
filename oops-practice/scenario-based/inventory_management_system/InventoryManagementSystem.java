package inventory_management_system;

public class InventoryManagementSystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 10, 5);
        Product p2 = new Product(102, "Keyboard", 4, 5);
        Product p3 = new Product(103, "Mouse", 20, 5);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        inventory.trackProducts();

        try {
            inventory.updateStock(101, 3);
            inventory.updateStock(102, 2);
            inventory.updateStock(103, 0);   // exception case
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFinal Inventory Status");
        inventory.trackProducts();
    }
}

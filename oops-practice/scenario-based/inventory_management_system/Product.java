package inventory_management_system;

public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int lowStockLimit;

    public Product(int productId, String productName, int quantity, int lowStockLimit) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.lowStockLimit = lowStockLimit;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowStockLimit() {
        return lowStockLimit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayProduct() {
        System.out.println(
                "ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity
        );
    }
}

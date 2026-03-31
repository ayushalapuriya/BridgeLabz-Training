package inventory_management_system;

import java.util.*;

public class Inventory implements AlertService {

    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductName());
    }

    public void updateStock(int productId, int newQuantity)
            throws OutOfStockException {

        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if (newQuantity <= 0) {
            throw new OutOfStockException(
                    "Product " + product.getProductName() + " is out of stock"
            );
        }

        product.setQuantity(newQuantity);
        checkLowStock(product);
    }

    public void trackProducts() {
        System.out.println("\nTracking Inventory");
        for (Product p : products.values()) {
            p.displayProduct();
            checkLowStock(p);
        }
    }

    @Override
    public void checkLowStock(Product product) {
        if (product.getQuantity() <= product.getLowStockLimit()) {
            System.out.println(
                    "Alert: Low stock for product " + product.getProductName()
            );
        }
    }
}

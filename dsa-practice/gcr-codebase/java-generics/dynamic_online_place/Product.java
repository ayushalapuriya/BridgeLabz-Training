package dynamic_online_place;

public class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    public void displayProduct() {
        System.out.println(name + " | " + category.getCategoryName() + " | $" + price);
    }
}

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " Price:" + price + " Rating:" + rating + " Discount:" + discount;
    }
}

public class CustomSortingInEcommerce {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 75000, 4.5, 10));
        products.add(new Product("Phone", 40000, 4.2, 15));
        products.add(new Product("Headphones", 3000, 4.8, 25));
        products.add(new Product("Tablet", 25000, 4.1, 5));

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);

        System.out.println();

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(System.out::println);

        System.out.println();

        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        products.forEach(System.out::println);
    }
}

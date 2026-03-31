package dynamic_online_place;

public class Main {
    public static void main(String[] args) {
        Product<BookCategory> book =
                new Product<>("Java Programming", 500, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 800, new ClothingCategory());

        DiscountService.applyDiscount(book, 10);
        DiscountService.applyDiscount(shirt, 20);

        book.displayProduct();
        shirt.displayProduct();
    }
}

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String,Integer> cart = new LinkedHashMap<>();
        cart.put("Apple",100);
        cart.put("Milk",50);

        cart.forEach((k,v)->System.out.println(k+" ₹"+v));
    }
}

import java.util.*;

public class StockLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(100.5, 101.2, 102.8);
        prices.forEach(p -> System.out.println("Stock price: " + p));
    }
}

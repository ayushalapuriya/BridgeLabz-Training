import java.util.*;
import java.util.stream.Collectors;

class Order {
    String customer;
    double total;
    Order(String customer, double total) { this.customer = customer; this.total = total; }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 200.0),
            new Order("Bob", 150.0),
            new Order("Alice", 300.0)
        );

        Map<String, Double> revenueByCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.customer,
                Collectors.summingDouble(o -> o.total)
            ));

        System.out.println(revenueByCustomer);
    }
}

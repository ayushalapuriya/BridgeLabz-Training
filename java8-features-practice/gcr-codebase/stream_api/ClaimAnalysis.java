import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Claim {
    String type;
    double amount;
    Claim(String t, double a) { type = t; amount = a; }
}

public class ClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Health", 3000),
            new Claim("Vehicle", 2000),
            new Claim("Vehicle", 4000)
        );

        Map<String, Double> avgByType = claims.stream()
            .collect(groupingBy(c -> c.type, averagingDouble(c -> c.amount)));

        avgByType.forEach((type, avg) -> System.out.println(type + ": " + avg));
    }
}

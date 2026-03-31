import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseNames {
    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "Alice Johnson",
                "Bob Smith",
                "Charlie Brown"
        );

        List<String> uppercasedNames = employeeNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        uppercasedNames.forEach(System.out::println);
    }
}

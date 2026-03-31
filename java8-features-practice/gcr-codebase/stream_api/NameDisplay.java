import java.util.*;
import java.util.stream.*;

public class NameDisplay {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}

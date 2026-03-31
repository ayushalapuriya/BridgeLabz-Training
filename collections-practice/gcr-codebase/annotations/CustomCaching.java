import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {

    static Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int square(int n) {
        System.out.println("Computing...");
        return n * n;
    }
}

public class CustomCaching {
    public static void main(String[] args) throws Exception {

        Calculator c = new Calculator();
        Method m = Calculator.class.getDeclaredMethod("square", int.class);

        int input = 5;

        if (Calculator.cache.containsKey(input)) {
            System.out.println(Calculator.cache.get(input));
        } else {
            int result = (int) m.invoke(c, input);
            Calculator.cache.put(input, result);
            System.out.println(result);
        }
    }
}

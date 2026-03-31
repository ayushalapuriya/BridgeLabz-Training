import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        int limit = 10;
        Function<String, Integer> getLength = String::length;

        String[] messages = {"Hello", "This is a long message", "Java", "Functional interface"};

        for (String msg : messages) {
            if (getLength.apply(msg) > limit) {
                System.out.println("Message exceeds limit: " + msg);
            } else {
                System.out.println("Message within limit: " + msg);
            }
        }
    }
}

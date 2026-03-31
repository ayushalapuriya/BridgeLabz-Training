import java.lang.reflect.*;

class Person {
    private int age = 10;
}

public class AccessAndModify {
    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("Person");

            Object obj = cls.getDeclaredConstructor().newInstance();

            System.out.println("\nClass Name: " + cls.getName());
            System.out.println("----------------------------------------------");

            Field field = cls.getDeclaredField("age");
            field.setAccessible(true);

            System.out.println("Original Age: " + field.get(obj));

            field.set(obj, 15);

            System.out.println("Modified Age: " + field.get(obj));
            System.out.println("----------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}

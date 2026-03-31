import java.lang.reflect.*;

class Student {
    String name = "Ayush";
    int age = 21;
}

public class DynamicallyCreateObject {
    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("Student");

            Object obj = cls.getDeclaredConstructor().newInstance();

            Student s = (Student) obj;

            System.out.println("Student name: " + s.name);
            System.out.println("Student age: " + s.age);

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fully qualified class name: ");
        String className = sc.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());
            System.out.println("----------------------------------------------");

            System.out.println("\nMethods:");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println(method);
            }
            System.out.println("----------------------------------------------");

            System.out.println("\nFields:");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println(field);
            }
            System.out.println("----------------------------------------------");

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                System.out.println(constructor);
            }
            System.out.println("----------------------------------------------");

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        sc.close();
    }
}

import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name: ");
        String methodName = sc.next();

        Class<?> c = MathOperations.class;
        Object obj = c.getDeclaredConstructor().newInstance();

        Method m = c.getDeclaredMethod(methodName, int.class, int.class);
        System.out.println(m.invoke(obj, 10, 5));
    }
}

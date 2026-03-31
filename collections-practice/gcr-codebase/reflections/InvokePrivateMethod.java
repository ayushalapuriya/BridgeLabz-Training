import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {

        Class<?> c = Calculator.class;
        Object obj = c.getDeclaredConstructor().newInstance();

        Method m = c.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);

        System.out.println("Mutliply of " + " a & b " + " is "+m.invoke(obj, 2, 4));
    }
}

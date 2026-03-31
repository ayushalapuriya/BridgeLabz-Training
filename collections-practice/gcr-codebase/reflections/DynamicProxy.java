import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello");
    }
}

public class DynamicProxy {
    public static void main(String[] args) {

        Greeting g = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (obj, method, params) -> {
                System.out.println(method.getName());
                return method.invoke(new GreetingImpl(), params);
            }
        );

        g.sayHello();
    }
}

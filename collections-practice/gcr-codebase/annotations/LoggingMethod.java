import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Task1 {

    @LogExecutionTime
    public void process() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class LoggingMethod {
    public static void main(String[] args) throws Exception {

        Task1 t = new Task1();
        Method m = Task1.class.getDeclaredMethod("process");

        long start = System.nanoTime();
        m.invoke(t);
        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start));
    }
}

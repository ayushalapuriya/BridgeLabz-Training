import java.lang.reflect.*;

class Task {
    public void run() {
        for(int i=0;i<1000000;i++);
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {

        Task t = new Task();
        Method m = Task.class.getDeclaredMethod("run");

        long start = System.nanoTime();
        m.invoke(t);
        long end = System.nanoTime();

        System.out.println(end - start);
    }
}

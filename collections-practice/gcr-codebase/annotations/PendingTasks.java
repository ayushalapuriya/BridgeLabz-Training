import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Add Login", assignedTo = "Ayush", priority = "HIGH")
    public void login() {}

    @Todo(task = "Improve UI", assignedTo = "Rahul")
    public void ui() {}
}

public class PendingTasks {
    public static void main(String[] args) {

        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(t.task() + " | " + t.assignedTo() + " | " + t.priority());
            }
        }
    }
}

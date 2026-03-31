import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void payment() {}

    @ImportantMethod(level = "LOW")
    public void logging() {}

    public void normal() {}
}

public class MarkImportantsMethods {
    public static void main(String[] args) {
    	System.out.println("Method Name " + " : " + " Method Level");
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + "	 : " + im.level());
            }
        }
    }
}

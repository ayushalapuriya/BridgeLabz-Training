import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User1 {

    @MaxLength(5)
    String username;

    User1(String username) throws Exception {
        Field f = this.getClass().getDeclaredField("username");
        MaxLength ml = f.getAnnotation(MaxLength.class);

        if (username.length() > ml.value())
            throw new IllegalArgumentException("Length exceeded");

        this.username = username;
    }
}

public class FieldValidation {
    public static void main(String[] args) throws Exception {
        new User1("Ayush");     // OK
        // new User("Ayush123"); // Exception
    }
}

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {

    @JsonField(name = "user_name")
    String name = "Ayush";

    int age = 21;
}

public class CustomSerialization {
    public static void main(String[] args) throws Exception {

        User u = new User();
        StringBuilder json = new StringBuilder("{");

        for (Field f : u.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                json.append("\"").append(jf.name()).append("\":\"")
                    .append(f.get(u)).append("\",");
            }
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        System.out.println(json);
    }
}

import java.lang.reflect.*;
import java.util.*;

class User {
    String name;
    int age;
}

public class CustomObjectWrapper {

    static <T> T toObject(Class<T> c, Map<String, Object> map) throws Exception {
        T obj = c.getDeclaredConstructor().newInstance();

        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(obj, map.get(f.getName()));
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Ayush");
        map.put("age", 21);

        User u = toObject(User.class, map);
        System.out.println("User name: " + u.name + "  , User age: " + u.age);
    }
}

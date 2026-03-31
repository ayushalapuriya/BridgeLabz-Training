import java.lang.reflect.*;

class Person1{
	String name = "Ayush";
    int age = 21;
}

public class JSONFGeneratorByReflection {
    public static void main(String[] args) throws Exception {

        Person1 p = new Person1();
        Class<?> c = p.getClass();

        StringBuilder json = new StringBuilder("{");

        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            json.append("\"").append(f.getName()).append("\":\"")
                .append(f.get(p)).append("\",");
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        System.out.println(json);
    }
}

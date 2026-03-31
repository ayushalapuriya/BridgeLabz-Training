import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

public class StudentJson {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Rahul");
        student.put("age", 22);

        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Math");
        subjects.add("Physics");
        subjects.add("Java");

        student.set("subjects", subjects);

        System.out.println(student.toPrettyString());
    }
}

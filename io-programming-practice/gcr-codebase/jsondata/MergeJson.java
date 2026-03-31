import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        // First JSON
        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Rahul");
        json1.put("age", 26);

        // Second JSON
        ObjectNode json2 = mapper.createObjectNode();
        json2.put("email", "rahul@gmail.com");
        json2.put("city", "Delhi");

        // Merge json2 into json1
        json1.setAll(json2);

        System.out.println(json1.toPrettyString());
    }
}

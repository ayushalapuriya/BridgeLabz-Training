import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJson {
    public static void main(String[] args) throws Exception {

        String json = """
        [
          {"name":"Amit", "age":22},
          {"name":"Rohit", "age":30},
          {"name":"Sita", "age":28},
          {"name":"Geeta", "age":24}
        ]
        """;

        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON array
        ArrayNode array = (ArrayNode) mapper.readTree(json);

        System.out.println("Records with age > 25:");
        for (JsonNode node : array) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node.toPrettyString());
            }
        }
    }
}

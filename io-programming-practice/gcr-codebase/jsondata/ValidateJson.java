import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        // Try changing this JSON to test
        String json = "{ \"name\": \"Rahul\", \"age\": 25 }";

        try {
            mapper.readTree(json);
            System.out.println("JSON is VALID ✅");
        } catch (Exception e) {
            System.out.println("JSON is INVALID ❌");
        }
    }
}

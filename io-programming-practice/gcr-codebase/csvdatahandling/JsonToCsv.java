import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.*;

import java.io.*;

public class JsonToCsv {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("C:\\Users\\alapu\\Downloads\\students.csv"));

            BufferedWriter bw = new BufferedWriter(
                new FileWriter("students.csv"));

            bw.write("id,name,age");
            bw.newLine();

            for (JsonNode node : root) {
                bw.write(
                    node.get("id").asInt() + "," +
                    node.get("name").asText() + "," +
                    node.get("age").asInt()
                );
                bw.newLine();
            }

            bw.close();
            System.out.println("JSON to CSV done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

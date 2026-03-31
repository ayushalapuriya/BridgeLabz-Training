import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.io.*;

public class CsvToJson {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("students.csv"));

            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                ObjectNode obj = mapper.createObjectNode();
                obj.put("id", Integer.parseInt(d[0]));
                obj.put("name", d[1]);
                obj.put("age", Integer.parseInt(d[2]));

                array.add(obj);
            }

            br.close();
            mapper.writeValue(new File("students.json"), array);
            System.out.println("CSV to JSON done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

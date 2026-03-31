import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.List;

// UC15
public class JSONDataSource implements DataSource {

    public void save(List<Contact> contacts) throws Exception {

        Gson gson = new Gson();

        FileWriter writer = new FileWriter("addressbook.json");

        gson.toJson(contacts, writer);

        writer.close();

        System.out.println("Saved to JSON File");
    }
}

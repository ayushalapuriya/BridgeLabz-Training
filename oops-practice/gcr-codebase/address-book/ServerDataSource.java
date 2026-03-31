import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.util.List;
import com.google.gson.Gson;

// UC16
public class ServerDataSource implements DataSource {

    public void save(List<Contact> contacts) throws Exception {

        URL url = new URL("http://localhost:3000/contacts");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        Gson gson = new Gson();
        String json = gson.toJson(contacts);

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        System.out.println("Saved to JSON Server");
    }
}

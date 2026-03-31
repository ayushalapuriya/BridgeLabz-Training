import java.io.FileWriter;
import java.util.List;

// UC13
public class FileDataSource implements DataSource {

    public void save(List<Contact> contacts) throws Exception {

        FileWriter writer = new FileWriter("addressbook.txt");

        for(Contact c : contacts){
            writer.write(c.toString() + "\n");
        }

        writer.close();

        System.out.println("Saved to Text File");
    }
}

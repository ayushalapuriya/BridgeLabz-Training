import java.io.FileWriter;
import java.util.List;

// UC14
public class CSVDataSource implements DataSource {

    public void save(List<Contact> contacts) throws Exception {

        FileWriter writer = new FileWriter("addressbook.csv");

        for(Contact c : contacts){
            writer.write(c.firstName + "," +
                         c.lastName + "," +
                         c.city + "," +
                         c.state + "\n");
        }

        writer.close();

        System.out.println("Saved to CSV File");
    }
}

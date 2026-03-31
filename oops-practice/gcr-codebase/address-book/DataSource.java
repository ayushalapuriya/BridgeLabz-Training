import java.util.List;

// UC18
public interface DataSource {

    void save(List<Contact> contacts) throws Exception;
}

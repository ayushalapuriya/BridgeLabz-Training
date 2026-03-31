import java.io.Serializable;

class CustomerData implements Serializable {
    String name;
    CustomerData(String name) { this.name = name; }
}

public class BackupTest {
    public static void main(String[] args) {
        CustomerData data = new CustomerData("John Doe");
        System.out.println("CustomerData is serializable: " + (data instanceof Serializable));
    }
}

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        Pattern email = Pattern.compile("^[\\w.-]+@[\\w.-]+$");
        Pattern phone = Pattern.compile("\\d{10}");
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alapu\\Downloads\\email_phone.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (!email.matcher(d[2]).matches() || !phone.matcher(d[3]).matches())
                System.out.println("Invalid: " + line);
        }
        br.close();
    }
}

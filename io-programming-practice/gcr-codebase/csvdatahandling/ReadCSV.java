import java.io.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\alapu\\Downloads\\students.csv")
        );

        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            System.out.println("ID:" + d[0] + "\tName: " + d[1] + "\tAge: " + d[2] + "\t\tMarks: " + d[3]);
        }
        br.close();
    }
}

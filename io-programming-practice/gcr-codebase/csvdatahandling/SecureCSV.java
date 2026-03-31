import java.io.*;
import java.util.Base64;

public class SecureCSV {

    static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    static String decrypt(String data) {
        return new String(Base64.getDecoder().decode(data));
    }

    public static void main(String[] args) {

        String fileName = "secure.csv";

        try {
            // ================= WRITE ENCRYPTED CSV =================
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write("id,name,email,salary");
            bw.newLine();

            bw.write("1,Rahul," +
                    encrypt("rahul@gmail.com") + "," +
                    encrypt("50000"));
            bw.newLine();

            bw.write("2,Amit," +
                    encrypt("amit@gmail.com") + "," +
                    encrypt("60000"));
            bw.newLine();

            bw.close();
            System.out.println("Encrypted CSV written successfully\n");

            // ================= READ & DECRYPT CSV =================
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine(); // skip header

            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                System.out.println("ID: " + d[0]);
                System.out.println("Name: " + d[1]);
                System.out.println("Email: " + decrypt(d[2]));
                System.out.println("Salary: " + decrypt(d[3]));
                System.out.println("-------------------------");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alapu\\Downloads\\employees.csv"));
        FileWriter fw = new FileWriter("C:\\Users\\alapu\\Downloads\\updatedEmployees.csv");
        String line;
        fw.write(br.readLine() + "\n");
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[2].equals("IT"))
                d[3] = String.valueOf((int)(Integer.parseInt(d[3]) * 1.1));
            fw.write(String.join(",", d) + "\n");
        }
        System.out.println("Update successfully..");
        br.close();
        fw.close();
    }
}

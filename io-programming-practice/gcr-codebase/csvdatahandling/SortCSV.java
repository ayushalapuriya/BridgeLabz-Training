import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) throws Exception {
        List<String[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alapu\\Downloads\\employees.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null)
            list.add(line.split(","));
        list.sort((a,b)->Integer.parseInt(b[3]) - Integer.parseInt(a[3]));
        for (int i=0;i<5;i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
        br.close();
    }
}

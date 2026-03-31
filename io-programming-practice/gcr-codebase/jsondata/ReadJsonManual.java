import java.io.File;
import java.util.Scanner;

public class ReadJsonManual {
    public static void main(String[] args) throws Exception {
        File file = new File("user.json");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String json = sb.toString().trim();

        // Remove { } and split by comma
        json = json.substring(1, json.length()-1); // remove {}
        String[] pairs = json.split(",");

        for(String pair : pairs){
            String[] kv = pair.split(":");
            String key = kv[0].trim().replaceAll("\"", "");
            String value = kv[1].trim().replaceAll("\"", "");
            System.out.println(key + " : " + value);
        }
    }
}

import java.util.*;
import java.io.*;

public class JsonToXmlManual {
    public static void main(String[] args) throws Exception {

        File file = new File("user.json");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) sb.append(sc.nextLine());
        sc.close();

        String json = sb.toString().trim();
        json = json.replaceAll("[{}\"]", ""); // remove braces and quotes
        String[] pairs = json.split(",");

        System.out.println("<root>");
        for(String pair : pairs){
            String[] kv = pair.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            System.out.println("  <"+key+">"+value+"</"+key+">");
        }
        System.out.println("</root>");
    }
}

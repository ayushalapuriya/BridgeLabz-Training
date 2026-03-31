import java.io.*;
import java.util.*;

public class CsvToJsonManual {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("user.csv"));
        String[] headers = sc.nextLine().split(","); // split by comma
        List<String> jsonObjects = new ArrayList<>();

        while(sc.hasNextLine()){
            String[] values = sc.nextLine().split(",");
            StringBuilder obj = new StringBuilder();
            obj.append("{");
            for(int i=0;i<headers.length;i++){
                obj.append("\""+headers[i].trim()+"\":");
                // Check if value is number
                try{
                    int n = Integer.parseInt(values[i].trim());
                    obj.append(n);
                }catch(Exception e){
                    obj.append("\""+values[i].trim()+"\"");
                }
                if(i<headers.length-1) obj.append(", ");
            }
            obj.append("}");
            jsonObjects.add(obj.toString());
        }
        sc.close();

        System.out.println("[");
        for(int i=0;i<jsonObjects.size();i++){
            System.out.print("  "+jsonObjects.get(i));
            if(i<jsonObjects.size()-1) System.out.println(",");
        }
        System.out.println("\n]");
    }
}

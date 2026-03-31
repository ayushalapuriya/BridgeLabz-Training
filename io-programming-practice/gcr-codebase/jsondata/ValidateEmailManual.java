import java.util.regex.*;

public class ValidateEmailManual {
    public static void main(String[] args){
        String json = "{\"name\":\"Rohit\",\"email\":\"rohit@gmail.com\"}";
        json = json.replaceAll("\\{|\\}|\"","");
        String[] pairs = json.split(",");
        String email = "";
        for(String p : pairs){
            String[] kv = p.split(":");
            if(kv[0].trim().equals("email")) email = kv[1].trim();
        }

        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if(Pattern.matches(regex,email)) System.out.println("Valid Email ✅");
        else System.out.println("Invalid Email ❌");
    }
}

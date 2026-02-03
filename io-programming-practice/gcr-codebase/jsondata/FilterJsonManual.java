
public class FilterJsonManual {
    public static void main(String[] args){
        String json = "[{\"name\":\"Amit\",\"age\":22},{\"name\":\"Rohit\",\"age\":30}]";

        json = json.substring(1, json.length()-1); // remove [ ]
        String[] records = json.split("\\},\\{");

        for(String rec : records){
            rec = rec.replaceAll("\\{|\\}", "");
            String[] fields = rec.split(",");
            int age = 0;
            String name = "";
            for(String field : fields){
                String[] kv = field.split(":");
                String key = kv[0].replaceAll("\"","");
                String value = kv[1].replaceAll("\"","");
                if(key.equals("age")) age = Integer.parseInt(value);
                if(key.equals("name")) name = value;
            }
            if(age>25) System.out.println(name+" : "+age);
        }
    }
}

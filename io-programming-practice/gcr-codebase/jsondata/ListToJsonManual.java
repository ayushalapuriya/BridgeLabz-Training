import java.util.*;

public class ListToJsonManual {
    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 2022, 4500000));
        cars.add(new Car("Audi", 2021, 4200000));

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i=0;i<cars.size();i++){
            Car c = cars.get(i);
            sb.append("  {");
            sb.append("\"brand\":\""+c.brand+"\", ");
            sb.append("\"year\":"+c.year+", ");
            sb.append("\"price\":"+c.price);
            sb.append("}");
            if(i<cars.size()-1) sb.append(",\n");
        }
        sb.append("\n]");
        System.out.println(sb.toString());
    }
}

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListToJson {
    public static void main(String[] args) throws Exception {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 2022, 4500000));
        cars.add(new Car("Audi", 2021, 4200000));
        cars.add(new Car("Toyota", 2023, 1800000));

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}

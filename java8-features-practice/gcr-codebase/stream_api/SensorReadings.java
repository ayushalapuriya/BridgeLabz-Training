import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(45.0, 75.5, 60.2);
        double threshold = 50.0;
        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("High reading: " + r));
    }
}

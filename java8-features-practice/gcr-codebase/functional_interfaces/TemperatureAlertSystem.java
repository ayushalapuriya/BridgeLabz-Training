import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        double threshold = 30.0;
        Predicate<Double> high = temp -> temp > threshold;
        double[] temperatures = {25.5, 30.0, 32.8, 28.4, 35.2};

        for (double temp : temperatures) {
            if (high.test(temp)) {
                System.out.println("Alert! High temperature detected: " + temp + "°C");
            } else {
                System.out.println("Temperature is normal: " + temp + "°C");
            }
        }
    }
}

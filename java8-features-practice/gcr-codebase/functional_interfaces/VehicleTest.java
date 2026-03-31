interface Vehicle {
    void displaySpeed();
    default void displayBattery() {
        System.out.println("Battery info not available for this vehicle");
    }
}

class ElectricVehicle implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }
    public void displayBattery() {
        System.out.println("Battery: 80%");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle ev = new ElectricVehicle();
        ev.displaySpeed();
        ev.displayBattery();
    }
}

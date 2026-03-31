interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light is turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

class AirConditioner implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is turned OFF");
    }
}

class TV implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("TV is turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}

public class SmartDeviceControlInterface {
    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AirConditioner();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();
        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}

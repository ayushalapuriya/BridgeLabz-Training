@FunctionalInterface
interface LightBehavior {
    void activate();
}

class SmartLight {
    private String name;

    public SmartLight(String name) {
        this.name = name;
    }

    public void trigger(LightBehavior behavior) {
        System.out.println("Triggering light: " + name);
        System.out.println("-----------------------------");
        behavior.activate();
    }
}

public class SmartHouseLightingAutomation {
    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("Living Room");
        SmartLight bedroomLight = new SmartLight("Bedroom");

        LightBehavior motionBehavior = () -> System.out.println("Lights turn on for 10 seconds.");
        LightBehavior eveningBehavior = () -> System.out.println("Lights dim to 50% for the evening ambiance.");
        LightBehavior voiceCommandBehavior = () -> System.out.println("Lights flash twice to acknowledge voice command.");

        livingRoomLight.trigger(motionBehavior);
        bedroomLight.trigger(eveningBehavior);
        livingRoomLight.trigger(voiceCommandBehavior);
    }
}

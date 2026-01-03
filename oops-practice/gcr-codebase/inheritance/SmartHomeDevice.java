
// Super class
class Device{
	String deviceId;
	String status;
	Device(String deviceId,String status){
		this.deviceId=deviceId;
		this.status=status;
	}
	void displayStatus(){
		System.out.println("Device ID: "+deviceId);
		System.out.println("Status: "+status);
		System.out.println();
	}
}

// Subclass Thermostat - inherits from Device
class Thermostat extends Device{
	double temperatureSetting;
	Thermostat(String deviceId,String status,double temperatureSetting){
		super(deviceId,status);
		this.temperatureSetting=temperatureSetting;
	}
	// Method overriding
	void displayStatus(){
		super.displayStatus();
		System.out.println("Temperature Setting: "+temperatureSetting+"°C");
		System.out.println();
	}
}

public class SmartHomeDevice{
	public static void main(String[] args){
		// Creating objects and demonstrating inheritance
		Thermostat thermostat=new Thermostat("TH001","Active",22.5);
		
		thermostat.displayStatus();
	}
}

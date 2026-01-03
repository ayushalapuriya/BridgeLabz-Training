
// Interface Refuelable
interface Refuelable{
	void refuel();
}

// Super class
class Vehicle{
	String model;
	int maxSpeed;
	Vehicle(String model,int maxSpeed){
		this.model=model;
		this.maxSpeed=maxSpeed;
	}
	void displayInfo(){
		System.out.println("Model: "+model);
		System.out.println("Max Speed: "+maxSpeed+" km/h");
		System.out.println();
	}
}

// Subclass ElectricVehicle - inherits from Vehicle
class ElectricVehicle extends Vehicle{
	int batteryCapacity;
	ElectricVehicle(String model,int maxSpeed,int batteryCapacity){
		super(model,maxSpeed);
		this.batteryCapacity=batteryCapacity;
	}
	// Method overriding
	void displayInfo(){
		System.out.println("Vehicle Type: Electric Vehicle");
		System.out.println("Model: "+model);
		System.out.println("Max Speed: "+maxSpeed+" km/h");
		System.out.println("Battery Capacity: "+batteryCapacity+" kWh");
		System.out.println();
	}
	void charge(){
		System.out.println(model+" is charging the battery.");
		System.out.println();
	}
}

// Subclass PetrolVehicle - inherits from Vehicle and implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable{
	int fuelTankCapacity;
	PetrolVehicle(String model,int maxSpeed,int fuelTankCapacity){
		super(model,maxSpeed);
		this.fuelTankCapacity=fuelTankCapacity;
	}
	// Method overriding
	void displayInfo(){
		System.out.println("Vehicle Type: Petrol Vehicle");
		System.out.println("Model: "+model);
		System.out.println("Max Speed: "+maxSpeed+" km/h");
		System.out.println("Fuel Tank Capacity: "+fuelTankCapacity+" liters");
		System.out.println();
	}
	// Interface method implementation
	public void refuel(){
		System.out.println(model+" is refueling with petrol.");
		System.out.println();
	}
}

public class VehicleManagementSystem{
	public static void main(String[] args){
		// Creating objects and demonstrating hybrid inheritance
		ElectricVehicle ev=new ElectricVehicle("Tesla Model 3",225,75);
		PetrolVehicle pv=new PetrolVehicle("Honda City",180,40);
		
		System.out.println("=== Vehicle Management System ===");
		System.out.println();
		
		ev.displayInfo();
		ev.charge();
		
		pv.displayInfo();
		pv.refuel();
	}
}

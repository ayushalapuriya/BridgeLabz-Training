
// Super class
class Vehicle {
	int maxSpeed;
	String fuelType;
	Vehicle(int maxSpeed,String fuelType){
		this.maxSpeed=maxSpeed;
		this.fuelType=fuelType;
	}
	void displayInfo() {
		System.out.println("Max Speed: "+maxSpeed+" km/h");
		System.out.println("Fuel Type: "+fuelType);
		System.out.println();
	}
}

// Subclass Car - inherits from Vehicle
class Car extends Vehicle{
	int seatCapacity;
	Car(int maxSpeed,String fuelType,int seatCapacity){
		super(maxSpeed,fuelType);
		this.seatCapacity=seatCapacity;
	}
	// Method overriding
	void displayInfo() {
		System.out.println("Car Details:");
		super.displayInfo();
		System.out.println("Seat Capacity: "+seatCapacity);
	}
}

// Subclass Truck - inherits from Vehicle
class Truck extends Vehicle{
	int loadCapacity;
	Truck(int maxSpeed,String fuelType,int loadCapacity){
		super(maxSpeed,fuelType);
		this.loadCapacity=loadCapacity;
	}
	// Method overriding
	void displayInfo() {
		System.out.println("Truck Details:");
		super.displayInfo();
		System.out.println("Load Capacity: "+loadCapacity+" tons");
	}
}

// Subclass Motorcycle - inherits from Vehicle
class Motorcycle extends Vehicle{
	boolean hasCarrier;
	Motorcycle(int maxSpeed,String fuelType,boolean hasCarrier){
		super(maxSpeed,fuelType);
		this.hasCarrier=hasCarrier;
	}
	// Method overriding
	void displayInfo() {
		System.out.println("Motorcycle Details:");
		super.displayInfo();
		System.out.println("Has Carrier: "+(hasCarrier?"Yes":"No"));
	}
}

public class TransportSystem {
	public static void main(String[] args) {
		// Polymorphism - storing different subclass objects in Vehicle array
		Vehicle[] vehicles=new Vehicle[3];
		vehicles[0]=new Car(180,"Petrol",5);
		vehicles[1]=new Truck(120,"Diesel",15);
		vehicles[2]=new Motorcycle(140,"Petrol",true);
		
		// Dynamic method calls based on actual object type
		for(int i=0;i<vehicles.length;i++){
			vehicles[i].displayInfo();
			System.out.println();
		}
	}
}

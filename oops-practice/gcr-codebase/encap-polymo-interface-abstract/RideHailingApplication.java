
// GPS interface - defines contract for location operations
interface GPS{
	String getCurrentLocation();
	void updateLocation(String location);
}

// Abstract Vehicle class
abstract class Vehicle{
	private String vehicleId;
	private String driverName;
	private double ratePerKm;
	
	// Setter for vehicle id
	public void setVehicleId(String vehicleId) {
		this.vehicleId=vehicleId;
	}
	
	// Setter for driver name
	public void setDriverName(String driverName) {
		this.driverName=driverName;
	}
	
	// Setter for rate per km
	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm=ratePerKm;
	}
	
	// Getter for vehicle id
	public String getVehicleId() {
		return this.vehicleId;
	}
	
	// Getter for driver name
	public String getDriverName() {
		return this.driverName;
	}
	
	// Getter for rate per km
	public double getRatePerKm() {
		return this.ratePerKm;
	}
	
	Vehicle(String vehicleId,String driverName,double ratePerKm){
		setVehicleId(vehicleId);
		setDriverName(driverName);
		setRatePerKm(ratePerKm);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateFare(double distance);
	
	// Concrete method to display vehicle details
	void getVehicleDetails() {
		System.out.println("Vehicle ID: "+getVehicleId());
		System.out.println("Driver Name: "+getDriverName());
		System.out.println("Rate per Km: Rs."+getRatePerKm());
	}
}

// Car class - implements GPS interface
class Car extends Vehicle implements GPS{
	private String currentLocation;
	private double baseFare=50;
	
	Car(String vehicleId,String driverName,double ratePerKm){
		super(vehicleId,driverName,ratePerKm);
		this.currentLocation="Garage";
	}
	
	@Override
	double calculateFare(double distance) {
		return baseFare+(distance*getRatePerKm());
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void updateLocation(String location) {
		this.currentLocation=location;
		System.out.println("Car location updated to: "+location);
	}
}

// Bike class - implements GPS interface
class Bike extends Vehicle implements GPS{
	private String currentLocation;
	private double baseFare=20;
	
	Bike(String vehicleId,String driverName,double ratePerKm){
		super(vehicleId,driverName,ratePerKm);
		this.currentLocation="Garage";
	}
	
	@Override
	double calculateFare(double distance) {
		return baseFare+(distance*getRatePerKm());
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void updateLocation(String location) {
		this.currentLocation=location;
		System.out.println("Bike location updated to: "+location);
	}
}

// Auto class - implements GPS interface
class Auto extends Vehicle implements GPS{
	private String currentLocation;
	private double baseFare=30;
	
	Auto(String vehicleId,String driverName,double ratePerKm){
		super(vehicleId,driverName,ratePerKm);
		this.currentLocation="Garage";
	}
	
	@Override
	double calculateFare(double distance) {
		return baseFare+(distance*getRatePerKm());
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void updateLocation(String location) {
		this.currentLocation=location;
		System.out.println("Auto location updated to: "+location);
	}
}

public class RideHailingApplication {
	public static void main(String[] args) {
		// Creating vehicle objects
		Car car=new Car("CAR001","Rajesh Kumar",15);
		Bike bike=new Bike("BIKE001","Amit Sharma",8);
		Auto auto=new Auto("AUTO001","Suresh Yadav",10);
		
		double rideDistance=12.5;
		
		// Polymorphism: Processing vehicles using Vehicle reference
		Vehicle[] vehicles={car,bike,auto};
		
		for(int i=0;i<vehicles.length;i++) {
			System.out.println("Vehicle "+(i+1)+":");
			vehicles[i].getVehicleDetails();
			System.out.println("Fare for "+rideDistance+" km: Rs."+vehicles[i].calculateFare(rideDistance));
			
			// Access interface method using downcasting
			if(vehicles[i] instanceof GPS) {
				GPS gpsVehicle=(GPS)vehicles[i];
				System.out.println("Current Location: "+gpsVehicle.getCurrentLocation());
				gpsVehicle.updateLocation("Connaught Place, Delhi");
			}
			System.out.println();
		}
	}
}

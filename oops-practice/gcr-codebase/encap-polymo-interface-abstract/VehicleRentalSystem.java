
// Insurable interface - defines contract for insurance operations
interface Insurable{
	void calculateInsurance();
	void getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle{
	private String vehicleNumber;
	private String type;
	private int rentalrate;
	
	// Setter for vehicle number
	public void setVehicleNum(String vehicleNumber) {
		this.vehicleNumber=vehicleNumber;
	}
	
	// Setter for vehicle type
	public void setType(String type) {
		this.type=type;
	}
	
	// Setter for rental rate
	public void setRentalRate(int rentalRate) {
		this.rentalrate=rentalRate;
	}
	
	// Getter for vehicle number
	public String getVehicleNum() {
		return this.vehicleNumber;
	}
	
	// Getter for vehicle type
	public String getType() {
		return this.type;
	}
	
	// Getter for rental rate
	public int getRentalRate() {
		return this.rentalrate;
	}
	
	Vehicle(String vehicleNumber,String type,int rentalRate){
		setVehicleNum(vehicleNumber);
		setType(type);
		setRentalRate(rentalRate);
	}
	
	// Abstract method
	abstract double calculateRentalCost(int days);
	
	// Concrete method to display vehicle details
	void displayDetails() {
		System.out.println("Vehicle Number: "+getVehicleNum());
		System.out.println("Vehicle Type: "+getType());
		System.out.println("Rental Rate per day: Rs."+getRentalRate());
	}
}

// Car class - implements Insurable interface
class Car extends Vehicle implements Insurable{
	private String insurancePolicy;
	
	Car(String vehicleNumber,String type,int rentalRate,String insurancePolicy){
		super(vehicleNumber,type,rentalRate);
		this.insurancePolicy=insurancePolicy;
	}
	
	@Override
	double calculateRentalCost(int days) {
		return days*getRentalRate();
	}
	public void calculateInsurance() {
		double insuranceCost=getRentalRate()*0.05;
		System.out.println("Insurance Cost per day: Rs."+insuranceCost);
	}
	public void getInsuranceDetails() {
		System.out.println("Insurance Policy: "+insurancePolicy);
		System.out.println("Coverage: Comprehensive");
	}
}

// Bike class - implements Insurable interface
class Bike extends Vehicle implements Insurable{
	private String insurancePolicy;
	
	Bike(String vehicleNumber,String type,int rentalRate,String insurancePolicy){
		super(vehicleNumber,type,rentalRate);
		this.insurancePolicy=insurancePolicy;
	}
	
	@Override
	double calculateRentalCost(int days) {
		return days*getRentalRate();
	}	
	public void calculateInsurance() {
		double insuranceCost=getRentalRate()*0.03;
		System.out.println("Insurance Cost per day: Rs."+insuranceCost);
	}
	public void getInsuranceDetails() {
		System.out.println("Insurance Policy: "+insurancePolicy);
		System.out.println("Coverage: Third Party");
	}
}

// Truck class - implements Insurable interface
class Truck extends Vehicle implements Insurable{
	private String insurancePolicy;
	
	Truck(String vehicleNumber,String type,int rentalRate,String insurancePolicy){
		super(vehicleNumber,type,rentalRate);
		this.insurancePolicy=insurancePolicy;
	}
	
	@Override
	double calculateRentalCost(int days) {
		return days*getRentalRate()*1.2;
	}	
	public void calculateInsurance() {
		double insuranceCost=getRentalRate()*0.08;
		System.out.println("Insurance Cost per day: Rs."+insuranceCost);
	}
	public void getInsuranceDetails() {
		System.out.println("Insurance Policy: "+insurancePolicy);
		System.out.println("Coverage: Commercial");
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
		// Creating vehicle objects
		Car car=new Car("MH01AB1234","Sedan",1500,"CAR-INS-2024-001");
		Bike bike=new Bike("MH02CD5678","Sports Bike",500,"BIKE-INS-2024-002");
		Truck truck=new Truck("MH03EF9012","Heavy Truck",3000,"TRUCK-INS-2024-003");
		
		int rentalDays=5;
		
		// Polymorphism: Processing vehicles using Vehicle reference
		Vehicle[] vehicles={car,bike,truck};
		
		for(int i=0;i<vehicles.length;i++) {
			System.out.println("Vehicle "+(i+1)+":");
			vehicles[i].displayDetails();
			System.out.println("Rental Cost for "+rentalDays+" days: Rs."+vehicles[i].calculateRentalCost(rentalDays));
			
			// Access interface method using downcasting
			if(vehicles[i] instanceof Insurable) {
				((Insurable)vehicles[i]).calculateInsurance();
				((Insurable)vehicles[i]).getInsuranceDetails();
			}
			System.out.println();
		}
	}
}


public class Vehicle {
	
	// Instance variables
	String ownerName;
	String vehicleType;
	
	// Class variable
	static double registrationFee=5000.0;
	
	// Constructor
	Vehicle(String ownerName,String vehicleType){
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
	}
	
	// Instance method to display vehicle details
	void displayVehicleDetails(){
		System.out.println("Owner Name: "+ownerName);
		System.out.println("Vehicle Type: "+vehicleType);
		System.out.println("Registration Fee: "+registrationFee);
		System.out.println("--------------------------");
	}
	
	// Class method to update registration fee
	static void updateRegistrationFee(double newFee){
		registrationFee=newFee;
		System.out.println("Registration fee updated to: "+newFee);
	}
	
	public static void main(String[] args) {
		Vehicle vehicle1=new Vehicle("Arun","Car");
		Vehicle vehicle2=new Vehicle("Priya","Bike");
		Vehicle vehicle3=new Vehicle("Karthik","Truck");
		
		System.out.println("Before updating registration fee:");
		vehicle1.displayVehicleDetails();
		vehicle2.displayVehicleDetails();
		vehicle3.displayVehicleDetails();
		
		Vehicle.updateRegistrationFee(7500.0);
		System.out.println();
		
		System.out.println("After updating registration fee:");
		vehicle1.displayVehicleDetails();
		vehicle2.displayVehicleDetails();
		vehicle3.displayVehicleDetails();
	}
}

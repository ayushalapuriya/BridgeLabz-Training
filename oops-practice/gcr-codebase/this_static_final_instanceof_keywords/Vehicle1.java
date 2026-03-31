
public class Vehicle1 {
	
	// Static variable
	private static double registrationFee=150.0;
	
	// Instance variables
	private String ownerName;
	private String vehicleType;
	
	// Final variable
	private final String registrationNumber;
	
	// Constructor using this keyword
	Vehicle1(String ownerName,String vehicleType,String registrationNumber){
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
		this.registrationNumber=registrationNumber;
	}
	
	// Static method to update registration fee
	public static void updateRegistrationFee(double newFee){
		registrationFee=newFee;
		System.out.println("Registration fee updated to: $"+newFee);
	}
	
	// Method to display vehicle details with instanceof check
	public void displayVehicleDetails(){
		if(this instanceof Vehicle1){
			System.out.println("Owner Name: "+ownerName);
			System.out.println("Vehicle Type: "+vehicleType);
			System.out.println("Registration Number: "+registrationNumber);
			System.out.println("Registration Fee: $"+registrationFee);
		}else{
			System.out.println("Object is not an instance of Vehicle1");
		}
	}
	
	public static void main(String[] args) {
		Vehicle1 vehicle1=new Vehicle1("Honest raj","Sedan","ABC123");
		Vehicle1 vehicle2=new Vehicle1("Price danish","SUV","XYZ789");
		
		vehicle1.displayVehicleDetails();
		vehicle2.displayVehicleDetails();
	}
}

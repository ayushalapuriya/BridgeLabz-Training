import java.util.ArrayList;
import java.util.List;

// Custom exception for invalid phone number
class NoDriverAvailableException extends Exception{
	NoDriverAvailableException(String message){
		super(message);
	}
}

interface FareCalculator{
	int calculateFare(int distance);
}

class NormalFare implements FareCalculator{
	public int calculateFare(int distance) {
		return distance*10;
	}
}

class PeakFare implements FareCalculator{
	public int calculateFare(int distance) {
		return distance*15;
	}
}

class User{
	private String userName;
	private int age;
	private String phoneNo;
	private List<Ride> rideHistory=new ArrayList<>();
	
	User(String name,int age,String phoneNo){
		this.userName = name;
		this.age = age;
		this.phoneNo = phoneNo;
	}
	public String getName(){
		return userName;
	}
	
	void bookRide(int distance,FareCalculator fc,Driver driver) throws NoDriverAvailableException {
		Ride ride = new Ride(distance,this,driver);
		int fare = fc.calculateFare(distance);
		ride.setFare(fare);
		rideHistory.add(ride);
		
		System.out.println("Ride booked successfully");
		System.out.println("Driver name: "+driver.getDriverName());
		System.out.println("Fare is: "+fare);
	}

	void showRideHistory() {
		System.out.println("Ride history of: "+userName);
		for(Ride ride:rideHistory) {
			System.out.println(ride);
		}
	}
}

class Driver{
	private String driverName;
	private String driverPhoneNo;
	private boolean available = true;
	
	Driver(String driverName,String driverPhoneNo){
		this.driverName = driverName;
		this.driverPhoneNo = driverPhoneNo;
	}
	
	boolean isAvailable() {
		return available;
	}
	
	void assignRide() {
		available = false;
	}
	
	public String getDriverName() {
		return driverName;
	}
	
}

class Ride{
	User user;
	Driver driver;
	int distance;
	int fare;
	
	Ride(int distance,User user,Driver driver) throws NoDriverAvailableException {

        if(driver == null || !driver.isAvailable()) {
            throw new NoDriverAvailableException("No driver available!");
        }
		this.distance = distance;
		this.user = user;
		this.driver = driver;
		driver.assignRide();
	}
	
	void setFare(int fare) {
		this.fare = fare;
	}
	
	@Override
	public String toString() {
		return "Ride Details: Driver - " + driver.getDriverName() + 
		       ", Distance - " + distance + " km, Fare - Rs." + fare;
	}
}

public class RideManagementSystem {
	public static void main(String[] args) {
		User user=new User("Aman",20,"1234567890");
		
		Driver driver=new Driver("Rahul","1234123465");
		
		FareCalculator fare=new NormalFare();
		
		try {
	        user.bookRide(10, fare, driver);
        }
		catch (NoDriverAvailableException e) {
	        System.out.println(e.getMessage());
	    }

	    user.showRideHistory();
	}
}

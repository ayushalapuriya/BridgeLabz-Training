
public class CarRental {
	
	// Attributes
	String customerName;
	String carModel;
	int rentalDays;
	double costPerDay;
	
	// Default constructor
	CarRental(){
		this.customerName="Customer";
		this.carModel="Standard Car";
		this.rentalDays=1;
		this.costPerDay=500.0;
	}
	
	// Parameterized constructor
	CarRental(String customerName,String carModel,int rentalDays,double costPerDay){
		this.customerName=customerName;
		this.carModel=carModel;
		this.rentalDays=rentalDays;
		this.costPerDay=costPerDay;
	}
	
	// Method to calculate total cost
	double calculateTotalCost(){
		return rentalDays*costPerDay;
	}
	
	// Method to display rental details
	void display(){
		System.out.println("Customer Name: "+customerName);
		System.out.println("Car Model: "+carModel);
		System.out.println("Rental Days: "+rentalDays);
		System.out.println("Cost Per Day: "+costPerDay);
		System.out.println("Total Cost: "+calculateTotalCost());
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		CarRental rental1=new CarRental();
		CarRental rental2=new CarRental("Suresh","Toyota Innova",5,1500.0);
		CarRental rental3=new CarRental("Priya","Honda City",3,1200.0);
		
		System.out.println("Default Rental:");
		rental1.display();
		
		System.out.println("Rental 1:");
		rental2.display();
		
		System.out.println("Rental 2:");
		rental3.display();
	}
}

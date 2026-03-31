
public class Circle1 {
	
	// Attribute
	double radius;
	
	// Default constructor with constructor chaining
	Circle1(){
		this(1.0);
	}
	
	// Parameterized constructor
	Circle1(double radius){
		this.radius=radius;
	}
	
	// Method to calculate area
	double calculateArea(){
		return 3.14*radius*radius;
	}
	
	// Method to display circle details
	void display(){
		System.out.println("Radius: "+radius);
		System.out.println("Area: "+calculateArea());
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		Circle1 circle1=new Circle1();
		Circle1 circle2=new Circle1(5.0);
		
		circle1.display();
		circle2.display();
	}
}

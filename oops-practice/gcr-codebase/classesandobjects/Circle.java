
public class Circle {
	
	// Attributes
	double radius;
	
	// Constructor
	Circle(double radius){
		this.radius=radius;
	}
	
	// Method to find area of circle
	double areaOfCircle() {
		double area=(3.14)*radius*radius;
		return area;
	}
	
	// Method to find circumference of circle
	double circumOfCircle() {
		double circum=2*3.14*radius;
		return circum;
	}
	
	// Display output
	void display() {
		System.out.println("Area of circle: "+areaOfCircle());
		System.out.println("Circumference of circle: "+circumOfCircle());
	}
	
	public static void main(String[] args) {
		Circle c=new Circle(1.2);
		
		c.display();
	}
}


public class Student1 {
	
	// Access modifiers
	public int rollNumber;
	protected String name;
	private double CGPA;
	
	// Constructor
	Student1(int rollNumber,String name,double CGPA){
		this.rollNumber=rollNumber;
		this.name=name;
		this.CGPA=CGPA;
	}
	
	// Public method to get CGPA
	public double getCGPA(){
		return CGPA;
	}
	
	// Public method to set CGPA
	public void setCGPA(double CGPA){
		if(CGPA>=0.0&&CGPA<=10.0){
			this.CGPA=CGPA;
			System.out.println("CGPA updated to: "+CGPA);
		}else{
			System.out.println("Invalid CGPA. Must be between 0.0 and 10.0");
		}
	}
	
	// Method to display student details
	public void display(){
		System.out.println("Roll Number: "+rollNumber);
		System.out.println("Name: "+name);
		System.out.println("CGPA: "+CGPA);
		System.out.println("--------------------------");
	}
}

// Subclass to demonstrate protected access
class PostgraduateStudent extends Student1{
	
	String researchArea;
	
	// Constructor
	PostgraduateStudent(int rollNumber,String name,double CGPA,String researchArea){
		super(rollNumber,name,CGPA);
		this.researchArea=researchArea;
	}
	
	// Method to display postgraduate student details
	public void display(){
		System.out.println("Roll Number: "+rollNumber);
		System.out.println("Name: "+name);
		System.out.println("CGPA: "+getCGPA());
		System.out.println("Research Area: "+researchArea);
		System.out.println("--------------------------");
	}
	
	// Method to demonstrate protected access
	public void displayProtectedName(){
		System.out.println("Accessing protected name from subclass: "+name);
	}
	
	public static void main(String[] args) {
		Student1 student1=new Student1(101,"Ramesh",8.5);
		System.out.println("Undergraduate Student:");
		student1.display();
		
		System.out.println("Accessing public member directly: "+student1.rollNumber);
		System.out.println("Accessing private member through getter: "+student1.getCGPA());
		student1.setCGPA(9.0);
		System.out.println();
		
		PostgraduateStudent pgStudent=new PostgraduateStudent(201,"Priya",9.2,"Artificial Intelligence");
		System.out.println("Postgraduate Student:");
		pgStudent.display();
		pgStudent.displayProtectedName();
	}
}

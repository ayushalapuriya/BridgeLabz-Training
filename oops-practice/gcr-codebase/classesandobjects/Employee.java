
public class Employee{
	
	// Attributes
	String name;
	int id;
	int salary;
	
	// Constructor
	Employee(String name,int id,int salary) {
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	// Method to display employee details
	public void display() {
		System.out.println("---- Employee Details ----");
		System.out.println("Employee name: "+name);
		System.out.println("Employee id: "+id);
		System.out.println("Employee salary: "+salary);
	}
	
	public static void main(String[] args) {
		Employee ed=new Employee("Rohan",1,500000);

		ed.display();
	}
}

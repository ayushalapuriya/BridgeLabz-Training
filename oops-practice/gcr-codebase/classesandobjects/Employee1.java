
public class Employee1 {
	
	// Access modifiers
	public String employeeID;
	protected String department;
	private double salary;
	
	// Constructor
	Employee1(String employeeID,String department,double salary){
		this.employeeID=employeeID;
		this.department=department;
		this.salary=salary;
	}
	
	// Public method to get salary
	public double getSalary(){
		return salary;
	}
	
	// Public method to set salary
	public void setSalary(double salary){
		if(salary>0){
			this.salary=salary;
			System.out.println("Salary updated to: "+salary);
		}else{
			System.out.println("Invalid salary amount");
		}
	}
	
	// Public method to give raise
	public void giveRaise(double percentage){
		if(percentage>0){
			double raiseAmount=salary*percentage/100;
			salary=salary+raiseAmount;
			System.out.println("Raise of "+percentage+"% given. New salary: "+salary);
		}else{
			System.out.println("Invalid percentage");
		}
	}
	
	// Method to display employee details
	public void display(){
		System.out.println("Employee ID: "+employeeID);
		System.out.println("Department: "+department);
		System.out.println("Salary: "+salary);
		System.out.println("--------------------------");
	}
}

// Subclass to demonstrate protected access
class Manager extends Employee1{
	
	String teamSize;
	
	// Constructor
	Manager(String employeeID,String department,double salary,String teamSize){
		super(employeeID,department,salary);
		this.teamSize=teamSize;
	}
	
	// Method to display manager details
	public void display(){
		System.out.println("Employee ID: "+employeeID);
		System.out.println("Department: "+department);
		System.out.println("Salary: "+getSalary());
		System.out.println("Team Size: "+teamSize);
		System.out.println("--------------------------");
	}
	
	// Method to demonstrate protected access
	public void displayProtectedDepartment(){
		System.out.println("Accessing protected department from subclass: "+department);
	}
	
	public static void main(String[] args) {
		Employee1 emp=new Employee1("EMP001","IT",50000.0);
		System.out.println("Regular Employee:");
		emp.display();
		
		System.out.println("Accessing public member directly: "+emp.employeeID);
		System.out.println("Accessing private member through getter: "+emp.getSalary());
		emp.setSalary(55000.0);
		emp.giveRaise(10.0);
		System.out.println();
		
		Manager manager=new Manager("MGR001","Sales",80000.0,"15 members");
		System.out.println("Manager:");
		manager.display();
		manager.displayProtectedDepartment();
		manager.giveRaise(15.0);
	}
}

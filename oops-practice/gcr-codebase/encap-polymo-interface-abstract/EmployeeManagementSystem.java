
// Department interface - defines contract for department operations
interface Department{
	void assignDepartment(String dept);
	void getDepartmentDetails();
}

// Abstract class
abstract class Employee{
	private String employeeId;
	private String name;
	private int baseSalary;
	
	// Setter for employee id
	public void setId(String employeeId) {
		this.employeeId=employeeId;
	}
	
	// Setter for employee name
	public void setName(String name) {
		this.name=name;
	}
	
	// Setter for employee base salary
	public void setBaseSalary(int baseSalary) {
		this.baseSalary=baseSalary;
	}
	
	// Getter for employee id
	public String getId() {
		return this.employeeId;
	}
	
	// Getter for employee name
	public String getName() {
		return this.name;
	}
	
	// Getter for employee base salary
	public int getBaseSalary() {
		return this.baseSalary;
	}
	
	Employee(String employeeId,String name,int baseSalary){
		setId(employeeId);
		setName(name);
		setBaseSalary(baseSalary);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateSalary();
	
	// Concrete method
	void displayDetails() {
		System.out.println("Id of employee: "+getId());
		System.out.println("Name of employee: "+getName());
		System.out.println("Base salary of employee:"+getBaseSalary());
	}
}

// FullTimeEmployee - receives fixed monthly salary
class FullTimeEmployee extends Employee implements Department{
	String dept;
	FullTimeEmployee(String employeeId,String name,int baseSalary){
		super(employeeId,name,baseSalary);
	}
	@Override
	double calculateSalary() {
		return getBaseSalary();
	}
	public void assignDepartment(String dept) {
		this.dept=dept;
	}
	public void getDepartmentDetails() {
		System.out.println("Department is: "+dept);
	}
}

// PartTimeEmployee - salary calculated based on hours worked
class PartTimeEmployee extends Employee implements Department{
	int workingHours;
	String dept;
	PartTimeEmployee(String employeeId,String name,int baseSalary,int hours){
		super(employeeId,name,baseSalary);
		this.workingHours=hours;
	}
	@Override
	double calculateSalary() {
		return (workingHours)*(getBaseSalary());
	}
	public void assignDepartment(String dept) {
		this.dept=dept;
	}
	public void getDepartmentDetails() {
		System.out.println("Department is: "+dept);
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		// Creating employee objects
		FullTimeEmployee fullTime=new FullTimeEmployee("101","Ayush",60000);
		PartTimeEmployee partTime=new PartTimeEmployee("102","Prateek",300,7);
		
		// Assigning departments
		fullTime.assignDepartment("Engineering");
		partTime.assignDepartment("Marketing");
		
		// Polymorphism: Processing employees using Employee reference
		Employee[] employees={fullTime,partTime};
		
		for(int i=0;i<employees.length;i++) {
			System.out.println("Employee "+(i+1)+" details:");
			employees[i].displayDetails();
			System.out.println("Calculated Salary: "+employees[i].calculateSalary());
			
			// Access interface method using downcasting
			if(employees[i] instanceof Department) {
				((Department)employees[i]).getDepartmentDetails();
			}
			System.out.println();
		}
	}
}

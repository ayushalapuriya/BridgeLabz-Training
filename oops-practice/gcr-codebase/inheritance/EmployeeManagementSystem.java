
// Super class
class Employee {
	String name;
	String id;
	int salary;
	Employee(String name,String id,int salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	void displayDetails() {
		System.out.println("Name of employee: "+name);
		System.out.println("Id of employee: "+id);
		System.out.println("Salary of employee: "+salary);
		System.out.println();
	}
}

// Subclass Manager - inherits from Employee
class Manager extends Employee{
	int teamSize;
	Manager(String name,String id,int salary,int teamSize){
		super(name,id,salary);
		this.teamSize=teamSize;
	}
	// Method overriding
	void displayDetails() {
		System.out.println("Name of manager: "+name);
		System.out.println("Id of manager: "+id);
		System.out.println("Salary of manager: "+salary);
		System.out.println("Teamsize of manager: "+teamSize);
		System.out.println();
	}
}

// Subclass Developer - inherits from Employee
class Developer extends Employee{
	String lang;
	Developer(String name,String id,int salary,String lang){
		super(name,id,salary);
		this.lang=lang;
	}
	// Method overriding
	void displayDetails() {
		System.out.println("Name of developer: "+name);
		System.out.println("Id of developer: "+id);
		System.out.println("Salary of developer: "+salary);
		System.out.println("Language of developer: "+lang);
		System.out.println();
	}
}

// Subclass Intern - inherits from Employee
class Intern extends Employee{
	Intern(String name,String id,int salary){
		super(name,id,salary);
	}
	// Method overriding
	void displayDetails() {
		System.out.println("Name of intern: "+name);
		System.out.println("Id of intern: "+id);
		System.out.println("Salary of intern: "+salary);
		System.out.println();
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		// Creating objects and demonstrating polymorphism
		Manager manager=new Manager("Shah","BL12",100000,6);
		Developer dev=new Developer("Sahil","BL22",70000,"java");
		Intern intern=new Intern("Ayush","BL40",20000);
		
		manager.displayDetails();
		dev.displayDetails();
		intern.displayDetails();
	}
}

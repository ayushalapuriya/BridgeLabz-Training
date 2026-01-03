
// Interface Worker
interface Worker{
	void performDuties();
}

// Super class
class Person{
	String name;
	String id;
	Person(String name,String id){
		this.name=name;
		this.id=id;
	}
	void displayInfo(){
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println();
	}
}

// Subclass Chef - inherits from Person and implements Worker
class Chef extends Person implements Worker{
	String specialization;
	Chef(String name,String id,String specialization){
		super(name,id);
		this.specialization=specialization;
	}
	// Method overriding
	void displayInfo(){
		System.out.println("Role: Chef");
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Specialization: "+specialization);
		System.out.println();
	}
	// Interface method implementation
	public void performDuties(){
		System.out.println(name+" is preparing delicious "+specialization+" dishes.");
		System.out.println();
	}
}

// Subclass Waiter - inherits from Person and implements Worker
class Waiter extends Person implements Worker{
	int tablesAssigned;
	Waiter(String name,String id,int tablesAssigned){
		super(name,id);
		this.tablesAssigned=tablesAssigned;
	}
	// Method overriding
	void displayInfo(){
		System.out.println("Role: Waiter");
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Tables Assigned: "+tablesAssigned);
		System.out.println();
	}
	// Interface method implementation
	public void performDuties(){
		System.out.println(name+" is serving customers at "+tablesAssigned+" tables.");
		System.out.println();
	}
}

public class ResturantManagementSystem{
	public static void main(String[] args){
		// Creating objects and demonstrating hybrid inheritance
		Chef chef=new Chef("Sanjeev Kapoor","CH001","Indian Cuisine");
		Waiter waiter=new Waiter("Ravi Kumar","WT001",5);
		
		System.out.println("=== Restaurant Management System ===");
		System.out.println();
		
		chef.displayInfo();
		chef.performDuties();
		
		waiter.displayInfo();
		waiter.performDuties();
	}
}

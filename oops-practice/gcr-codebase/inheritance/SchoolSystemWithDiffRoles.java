
// Super class
class Person{
	String name;
	int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	void displayRole(){
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println();
	}
}

// Subclass Teacher - inherits from Person
class Teacher extends Person{
	String subject;
	Teacher(String name,int age,String subject){
		super(name,age);
		this.subject=subject;
	}
	// Method overriding
	void displayRole(){
		System.out.println("Role: Teacher");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Subject: "+subject);
		System.out.println();
	}
}

// Subclass Student - inherits from Person
class Student extends Person{
	String grade;
	Student(String name,int age,String grade){
		super(name,age);
		this.grade=grade;
	}
	// Method overriding
	void displayRole(){
		System.out.println("Role: Student");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Grade: "+grade);
		System.out.println();
	}
}

// Subclass Staff - inherits from Person
class Staff extends Person{
	String department;
	Staff(String name,int age,String department){
		super(name,age);
		this.department=department;
	}
	// Method overriding
	void displayRole(){
		System.out.println("Role: Staff");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Department: "+department);
		System.out.println();
	}
}

public class SchoolSystemWithDiffRoles{
	public static void main(String[] args){
		// Creating objects and demonstrating hierarchical inheritance
		Teacher teacher=new Teacher("Mr. Sharma",35,"Mathematics");
		Student student=new Student("Rahul",16,"10th Grade");
		Staff staff=new Staff("Ms. Patel",28,"Administration");
		
		System.out.println("=== School System ===");
		System.out.println();
		
		teacher.displayRole();
		student.displayRole();
		staff.displayRole();
	}
}


public class Person {
	
	// Attributes
	String name;
	int age;
	String address;
	
	// Parameterized constructor
	Person(String name,int age,String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	// Copy constructor
	Person(Person other){
		this.name=other.name;
		this.age=other.age;
		this.address=other.address;
	}
	
	// Method to display person details
	void display(){
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Address: "+address);
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		Person person1=new Person("Rajesh",30,"Chennai");
		Person person2=new Person(person1);
		
		System.out.println("Original Person:");
		person1.display();
		
		System.out.println("Copied Person:");
		person2.display();
	}
}

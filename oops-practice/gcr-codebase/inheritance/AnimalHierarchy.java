
// Super class
class Animal {
	String name;
	int age;
	Animal(String name,int age){
		this.name=name;
		this.age=age;
	}
	void makeSound() {
		System.out.println("Sound of animal");
		System.out.println();
	}
}

// Subclass Dog - inherits from Animal
class Dog extends Animal {
	Dog(String name,int age){
		super(name,age);
	}
	// Method overriding
	void makeSound() {
		System.out.println("Dog barks");
		System.out.println();
	}
}

// Subclass Cat - inherits from Animal
class Cat extends Animal{
	Cat(String name,int age){
		super(name,age);
	}
	// Method overriding
	void makeSound() {
		System.out.println("Cat meows");
		System.out.println();
	}
}

// Subclass Bird - inherits from Animal
class Bird extends Animal{
	Bird(String name,int age){
		super(name,age);
	}
	// Method overriding
	void makeSound() {
		System.out.println("Bird chirp chirp");
		System.out.println();
	}
}

public class AnimalHierarchy {
	public static void main(String[] args) {
		// Creating objects and demonstrating polymorphism
		Dog dog=new Dog("Sheru",9);
		Cat cat=new Cat("Kitty",4);
		Bird bird=new Bird("Chiki",6);
		
		dog.makeSound();
		cat.makeSound();
		bird.makeSound();
	}
}

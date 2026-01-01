
public class Student2 {
	
	// Static variables
	private static String universityName="Global University";
	private static int totalStudents=0;
	
	// Instance variables
	private String name;
	private String grade;
	
	// Final variable
	private final int rollNumber;
	
	// Constructor using this keyword
	Student2(String name,int rollNumber,String grade){
		this.name=name;
		this.rollNumber=rollNumber;
		this.grade=grade;
		totalStudents++;
	}
	
	// Static method to display total students
	public static void displayTotalStudents(){
		System.out.println("Total Students Enrolled: "+totalStudents);
	}
	
	// Method to update grade with instanceof check
	public void updateGrade(String newGrade){
		if(this instanceof Student2){
			this.grade=newGrade;
			System.out.println("Grade updated to: "+newGrade);
		}else{
			System.out.println("Object is not an instance of Student2");
		}
	}
	
	// Method to display student details with instanceof check
	public void displayStudentDetails(){
		if(this instanceof Student2){
			System.out.println("University Name: "+universityName);
			System.out.println("Roll Number: "+rollNumber);
			System.out.println("Name: "+name);
			System.out.println("Grade: "+grade);
		}else{
			System.out.println("Object is not an instance of Student2");
		}
	}
	
	public static void main(String[] args) {
		Student2 student1=new Student2("Hemashree",101,"A");
		Student2 student2=new Student2("Sharmila",102,"B");
		
		Student2.displayTotalStudents();
		student1.displayStudentDetails();
		student2.displayStudentDetails();
		
		student2.updateGrade("A");
		student2.displayStudentDetails();
	}
}

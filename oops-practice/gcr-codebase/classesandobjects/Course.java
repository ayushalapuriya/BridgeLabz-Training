
public class Course {
	
	// Instance variables
	String courseName;
	int duration;
	double fee;
	
	// Class variable
	static String instituteName="Tech Academy";
	
	// Constructor
	Course(String courseName,int duration,double fee){
		this.courseName=courseName;
		this.duration=duration;
		this.fee=fee;
	}
	
	// Instance method to display course details
	void displayCourseDetails(){
		System.out.println("Institute Name: "+instituteName);
		System.out.println("Course Name: "+courseName);
		System.out.println("Duration: "+duration+" months");
		System.out.println("Fee: "+fee);
		System.out.println("--------------------------");
	}
	
	// Class method to update institute name
	static void updateInstituteName(String newName){
		instituteName=newName;
		System.out.println("Institute name updated to: "+newName);
	}
	
	public static void main(String[] args) {
		Course course1=new Course("Java Programming",6,25000.0);
		Course course2=new Course("Python Development",4,20000.0);
		Course course3=new Course("Web Development",3,15000.0);
		
		System.out.println("Before updating institute name:");
		course1.displayCourseDetails();
		course2.displayCourseDetails();
		course3.displayCourseDetails();
		
		Course.updateInstituteName("BridgeLabz Academy");
		System.out.println();
		
		System.out.println("After updating institute name:");
		course1.displayCourseDetails();
		course2.displayCourseDetails();
		course3.displayCourseDetails();
	}
}

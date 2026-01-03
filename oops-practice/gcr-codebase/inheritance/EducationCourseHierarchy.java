
// Super class
class Course{
	String courseName;
	int duration;
	Course(String courseName,int duration){
		this.courseName=courseName;
		this.duration=duration;
	}
	void displayCourseInfo(){
		System.out.println("Course Name: "+courseName);
		System.out.println("Duration: "+duration+" weeks");
		System.out.println();
	}
}

// Subclass OnlineCourse - inherits from Course
class OnlineCourse extends Course{
	String platform;
	boolean isRecorded;
	OnlineCourse(String courseName,int duration,String platform,boolean isRecorded){
		super(courseName,duration);
		this.platform=platform;
		this.isRecorded=isRecorded;
	}
	// Method overriding
	void displayCourseInfo(){
		System.out.println("Course Name: "+courseName);
		System.out.println("Duration: "+duration+" weeks");
		System.out.println("Platform: "+platform);
		System.out.println("Recorded: "+(isRecorded?"Yes":"No"));
		System.out.println();
	}
}

// Subclass PaidOnlineCourse - inherits from OnlineCourse (Multilevel Inheritance)
class PaidOnlineCourse extends OnlineCourse{
	double fee;
	double discount;
	PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount){
		super(courseName,duration,platform,isRecorded);
		this.fee=fee;
		this.discount=discount;
	}
	double getFinalPrice(){
		return fee-(fee*discount/100);
	}
	// Method overriding
	void displayCourseInfo(){
		System.out.println("Course Name: "+courseName);
		System.out.println("Duration: "+duration+" weeks");
		System.out.println("Platform: "+platform);
		System.out.println("Recorded: "+(isRecorded?"Yes":"No"));
		System.out.println("Fee: Rs. "+fee);
		System.out.println("Discount: "+discount+"%");
		System.out.println("Final Price: Rs. "+getFinalPrice());
		System.out.println();
	}
}

public class EducationCourseHierarchy{
	public static void main(String[] args){
		// Creating objects and demonstrating multilevel inheritance
		Course course1=new Course("Java Basics",4);
		OnlineCourse course2=new OnlineCourse("Python Programming",6,"Udemy",true);
		PaidOnlineCourse course3=new PaidOnlineCourse("Full Stack Development",12,"Coursera",true,15000,20);
		
		System.out.println("=== Education Course Hierarchy ===");
		System.out.println();
		
		course1.displayCourseInfo();
		course2.displayCourseInfo();
		course3.displayCourseInfo();
	}
}

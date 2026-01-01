
public class Employee2 {
	
	// Static variables
	private static String companyName="Tech Solutions Inc.";
	private static int totalEmployees=0;
	
	// Instance variables
	private String name;
	private String designation;
	
	// Final variable
	private final int id;
	
	// Constructor using this keyword
	Employee2(String name,int id,String designation){
		this.name=name;
		this.id=id;
		this.designation=designation;
		totalEmployees++;
	}
	
	// Static method to display total employees
	static void displayTotalEmployees(){
		System.out.println("Total Employees: "+totalEmployees);
	}
	
	// Method to display employee details with instanceof check
	void display(Object obj){
		if(obj instanceof Employee2){
			Employee2 emp=(Employee2)obj;
			System.out.println("Company Name: "+companyName);
			System.out.println("Employee ID: "+emp.id);
			System.out.println("Name: "+emp.name);
			System.out.println("Designation: "+emp.designation);
		}else{
			System.out.println("Object is not an instance of Employee2");
		}
	}
	
	public static void main(String[] args) {
		Employee2 emp1=new Employee2("Thamarai",101,"Software Engineer");
		Employee2 emp2=new Employee2("Rohan",102,"Project Manager");
		
		Employee2.displayTotalEmployees();
		emp1.display(emp1);
		emp2.display(emp2);
	}
}

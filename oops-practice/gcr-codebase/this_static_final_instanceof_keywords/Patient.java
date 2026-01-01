
public class Patient {
	
	// Static variables
	private static String hospitalName="City Hospital";
	private static int totalPatients=0;
	
	// Instance variables
	private String name;
	private int age;
	private String ailment;
	
	// Final variable
	private final String patientID;
	
	// Constructor using this keyword
	Patient(String patientID,String name,int age,String ailment){
		this.patientID=patientID;
		this.name=name;
		this.age=age;
		this.ailment=ailment;
		totalPatients++;
	}
	
	// Static method to get total patients
	public static void getTotalPatients(){
		System.out.println("Total Patients Admitted: "+totalPatients);
	}
	
	// Method to display patient details with instanceof check
	public void displayPatientDetails(){
		if(this instanceof Patient){
			System.out.println("Hospital Name: "+hospitalName);
			System.out.println("Patient ID: "+patientID);
			System.out.println("Name: "+name);
			System.out.println("Age: "+age);
			System.out.println("Ailment: "+ailment);
		}else{
			System.out.println("Object is not an instance of Patient");
		}
	}
	
	public static void main(String[] args) {
		Patient patient1=new Patient("P001","Lathika",30,"Flu");
		Patient patient2=new Patient("P002","Lidiya",45,"Fracture");
		
		Patient.getTotalPatients();
		patient1.displayPatientDetails();
		patient2.displayPatientDetails();
	}
}

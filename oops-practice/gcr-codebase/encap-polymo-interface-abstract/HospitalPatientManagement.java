
// MedicalRecord interface - defines contract for medical record operations
interface MedicalRecord{
	void addRecord(String record);
	void viewRecords();
}

// Abstract Patient class
abstract class Patient{
	private String patientId;
	private String name;
	private int age;
	
	// Setter for patient id
	public void setPatientId(String patientId) {
		this.patientId=patientId;
	}
	
	// Setter for name
	public void setName(String name) {
		this.name=name;
	}
	
	// Setter for age
	public void setAge(int age) {
		this.age=age;
	}
	
	// Getter for patient id
	public String getPatientId() {
		return this.patientId;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Getter for age
	public int getAge() {
		return this.age;
	}
	
	Patient(String patientId,String name,int age){
		setPatientId(patientId);
		setName(name);
		setAge(age);
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateBill();
	
	// Concrete method to display patient details
	void getPatientDetails() {
		System.out.println("Patient ID: "+getPatientId());
		System.out.println("Name: "+getName());
		System.out.println("Age: "+getAge());
	}
}

// InPatient class - implements MedicalRecord interface
class InPatient extends Patient implements MedicalRecord{
	private int daysAdmitted;
	private double roomChargePerDay=2000;
	private String diagnosis;
	private String medicalHistory;
	
	InPatient(String patientId,String name,int age,int daysAdmitted){
		super(patientId,name,age);
		this.daysAdmitted=daysAdmitted;
	}
	
	@Override
	double calculateBill() {
		double roomCharges=daysAdmitted*roomChargePerDay;
		double medicineCharges=5000;
		double doctorFees=3000;
		return roomCharges+medicineCharges+doctorFees;
	}
	public void addRecord(String record) {
		if(this.diagnosis==null) {
			this.diagnosis=record;
			System.out.println("Medical record added successfully!");
		}else {
			this.medicalHistory=record;
			System.out.println("Medical history updated!");
		}
	}
	public void viewRecords() {
		System.out.println("Diagnosis: "+(diagnosis!=null?diagnosis:"Not available"));
		System.out.println("Medical History: "+(medicalHistory!=null?medicalHistory:"Not available"));
	}
}

// OutPatient class - implements MedicalRecord interface
class OutPatient extends Patient implements MedicalRecord{
	private int consultations;
	private double consultationFee=500;
	private String diagnosis;
	private String medicalHistory;
	
	OutPatient(String patientId,String name,int age,int consultations){
		super(patientId,name,age);
		this.consultations=consultations;
	}
	
	@Override
	double calculateBill() {
		double consultationCharges=consultations*consultationFee;
		double medicineCharges=1500;
		return consultationCharges+medicineCharges;
	}
	public void addRecord(String record) {
		if(this.diagnosis==null) {
			this.diagnosis=record;
			System.out.println("Medical record added successfully!");
		}else {
			this.medicalHistory=record;
			System.out.println("Medical history updated!");
		}
	}
	public void viewRecords() {
		System.out.println("Diagnosis: "+(diagnosis!=null?diagnosis:"Not available"));
		System.out.println("Medical History: "+(medicalHistory!=null?medicalHistory:"Not available"));
	}
}

public class HospitalPatientManagement {
	public static void main(String[] args) {
		// Creating patient objects
		InPatient inPatient=new InPatient("IP001","Rahul Sharma",45,5);
		OutPatient outPatient=new OutPatient("OP001","Priya Singh",32,3);
		
		// Polymorphism: Processing patients using Patient reference
		Patient[] patients={inPatient,outPatient};
		
		for(int i=0;i<patients.length;i++) {
			System.out.println("Patient "+(i+1)+":");
			patients[i].getPatientDetails();
			System.out.println("Total Bill: Rs."+patients[i].calculateBill());
			
			// Access interface method using downcasting
			if(patients[i] instanceof MedicalRecord) {
				MedicalRecord medicalRecord=(MedicalRecord)patients[i];
				if(i==0) {
					medicalRecord.addRecord("Diabetes Type 2");
					medicalRecord.addRecord("Previous heart surgery in 2020");
				}else {
					medicalRecord.addRecord("Common Cold");
					medicalRecord.addRecord("No previous medical issues");
				}
				medicalRecord.viewRecords();
			}
			System.out.println();
		}
	}
}

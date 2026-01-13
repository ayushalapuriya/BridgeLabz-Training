import java.util.*;

// ================= EXCEPTIONS =================
class NoDoctorException extends Exception {
    NoDoctorException(String msg) { super(msg); }
}

class DoctorNotAvailableException extends Exception {
    DoctorNotAvailableException(String msg) { super(msg); }
}

class NoPatientException extends Exception {
    NoPatientException(String msg) { super(msg); }
}

class NoHistoryException extends Exception {
    NoHistoryException(String msg) { super(msg); }
}

class PatientNotFoundException extends Exception {
    PatientNotFoundException(String msg) { super(msg); }
}

// ================= ABSTRACTION =================
interface IPayable {
    int calculateBill();
}

// ================= PATIENT =================
class Patient {
    protected int id;
    protected String name;
    protected String diagnosis;

    Patient(int id, String name, String diagnosis) {
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public int getId() { return id; }

    public void displayInfo() {
        System.out.println("Patient Id : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Diagnosis  : " + diagnosis);
    }
}

// ================= INPATIENT =================
class InPatient extends Patient implements IPayable {
    private int days, charges;

    InPatient(int id, String name, String diagnosis, int days, int charges) {
        super(id, name, diagnosis);
        this.days = days;
        this.charges = charges;
    }

    public int calculateBill() {
        return days * charges;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admit Days : " + days);
        System.out.println("Charges   : ₹" + charges);
    }
}

// ================= OUTPATIENT =================
class OutPatient extends Patient implements IPayable {
    private int fee;

    OutPatient(int id, String name, String diagnosis, int fee) {
        super(id, name, diagnosis);
        this.fee = fee;
    }

    public int calculateBill() {
        return fee;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Consult Fee : ₹" + fee);
    }
}

// ================= DOCTOR =================
class Doctor {
    private int id;
    private String name;
    private int experience; // 👈 added
    private boolean available = true;
    private List<Patient> patients = new ArrayList<>();

    Doctor(int id, String name, int experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public boolean isAvailable() { return available; }

    public void assignPatient(Patient p) {
        patients.add(p);
        available = false;
    }

    public void removePatient(int pid) {
        patients.removeIf(p -> p.getId() == pid);
        available = true;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

// ================= HISTORY =================
class PatientHistory {
    Patient patient;
    String doctorName;
    int doctorExperience;
    int bill;

    PatientHistory(Patient p, Doctor d, int bill) {
        this.patient = p;
        this.doctorName = d.getName();
        this.doctorExperience = d.getExperience();
        this.bill = bill;
    }

    public void display() {
        patient.displayInfo();
        System.out.println("Doctor     : " + doctorName);
        System.out.println("Experience : " + doctorExperience + " years");
        System.out.println("Final Bill : ₹" + bill);
        System.out.println("-------------------------");
    }
}

// ================= MAIN =================
public class HospitalPatientManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Doctor> doctors = new ArrayList<>();
    static List<Patient> activePatients = new ArrayList<>();
    static List<PatientHistory> history = new ArrayList<>();

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n=== Hospital Menu ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. Admit Patient");
            System.out.println("3. Discharge Patient");
            System.out.println("4. View Patient History");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> admitPatient();
                case 3 -> dischargePatient();
                case 4 -> viewHistory();
                case 0 -> System.out.println("System Closed");
            }
        } while (choice != 0);
    }

    // ================= ADD DOCTOR =================
    static void addDoctor() {
        sc.nextLine();
        System.out.print("Doctor Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Experience (years): ");
        int exp = sc.nextInt();

        doctors.add(new Doctor(id, name, exp));
        System.out.println("Doctor Added Successfully!");
    }

    // ================= ADMIT PATIENT =================
    static void admitPatient() {
        try {
            if (doctors.isEmpty())
                throw new NoDoctorException("No doctors available. Add doctor first.");

            System.out.print("Doctor Id: ");
            int docId = sc.nextInt();

            Doctor doctor = null;
            for (Doctor d : doctors)
                if (d.getId() == docId) doctor = d;

            if (doctor == null)
                throw new DoctorNotAvailableException("Doctor not found.");

            if (!doctor.isAvailable())
                throw new DoctorNotAvailableException("Doctor is currently busy.");

            System.out.print("1.InPatient  2.OutPatient: ");
            int type = sc.nextInt();

            System.out.print("Patient Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Diagnosis: ");
            String diag = sc.nextLine();

            Patient p;
            if (type == 1) {
                System.out.print("Days: ");
                int d = sc.nextInt();
                System.out.print("Charges: ");
                int c = sc.nextInt();
                p = new InPatient(id, name, diag, d, c);
            } else {
                System.out.print("Fee: ");
                int f = sc.nextInt();
                p = new OutPatient(id, name, diag, f);
            }

            doctor.assignPatient(p);
            activePatients.add(p);
            System.out.println("Patient Assigned to " + doctor.getName());

        } catch (NoDoctorException | DoctorNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= DISCHARGE =================
    static void dischargePatient() {
        try {
            if (activePatients.isEmpty())
                throw new NoPatientException("No active patients.");

            System.out.print("Patient Id: ");
            int id = sc.nextInt();

            for (Doctor d : doctors) {
                for (Patient p : new ArrayList<>(d.getPatients())) {
                    if (p.getId() == id) {
                        int bill = ((IPayable) p).calculateBill();
                        history.add(new PatientHistory(p, d, bill));
                        d.removePatient(id);
                        activePatients.removeIf(x -> x.getId() == id);
                        System.out.println("Patient Discharged. Bill ₹" + bill);
                        return;
                    }
                }
            }
            throw new PatientNotFoundException("Patient not found.");

        } catch (NoPatientException | PatientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= HISTORY =================
    static void viewHistory() {
        try {
            if (history.isEmpty())
                throw new NoHistoryException("No patient history available.");

            for (PatientHistory h : history)
                h.display();

        } catch (NoHistoryException e) {
            System.out.println(e.getMessage());
        }
    }
}

package hospital_management_system;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int id, String name, String phone) {
        super(id, name, phone);
    }

    public void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewMedicalHistory() {
        System.out.println("Medical History:");
        if (medicalHistory.isEmpty()) {
            System.out.println("No records available");
        } else {
            for (String record : medicalHistory) {
                System.out.println("- " + record);
            }
        }
    }
}

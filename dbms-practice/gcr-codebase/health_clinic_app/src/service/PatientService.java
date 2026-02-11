package service;

import dao.PatientDAO;
import model.Patient;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    public void registerPatient(Patient patient) {

        if (patientDAO.isPatientExists(patient.getPhone(), patient.getEmail())) {
            System.out.println("❌ Patient already exists with this phone/email");
            return;
        }

        boolean success = patientDAO.addPatient(patient);
        if (success) {
            System.out.println("✅ Patient registered successfully");
        } else {
            System.out.println("❌ Failed to register patient");
        }
    }
    
    public Patient searchPatient(String input) {
        return patientDAO.findByIdOrPhone(input);
    }

    public void searchByName(String name) {
        patientDAO.findByName(name);
    }

    public void updatePatient(Patient p) {
        boolean updated = patientDAO.updatePatient(p);
        if (updated) {
            System.out.println("✅ Patient updated successfully");
        } else {
            System.out.println("❌ Update failed");
        }
    }

    
}

package service;

import java.util.List;

import dao.VisitDAO;
import model.Prescription;

public class VisitService {

    private VisitDAO dao = new VisitDAO();

    public void recordVisit(int appointmentId,
                            String diagnosis,
                            String notes,
                            List<Prescription> prescriptions) {

        if (dao.recordVisit(appointmentId, diagnosis, notes, prescriptions)) {
            System.out.println("✅ Visit recorded successfully");
        } else {
            System.out.println("❌ Visit recording failed");
        }
    }

    public void viewMedicalHistory(int patientId) {
        dao.viewMedicalHistory(patientId);
    }
}

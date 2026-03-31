package service;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorService {

    private DoctorDAO doctorDAO = new DoctorDAO();

    public void addDoctor(Doctor d) {
        if (doctorDAO.addDoctor(d)) {
            System.out.println("✅ Doctor added successfully");
        } else {
            System.out.println("❌ Failed to add doctor");
        }
    }

    public void viewDoctorsBySpecialty(String specialtyName) {
        doctorDAO.viewDoctorsBySpecialty(specialtyName);
    }

    public void updateSpecialty(int doctorId, int specialtyId) {
        if (doctorDAO.updateSpecialty(doctorId, specialtyId)) {
            System.out.println("✅ Specialty updated");
        } else {
            System.out.println("❌ Update failed");
        }
    }

    public void deactivateDoctor(int doctorId) {
        if (doctorDAO.deactivateDoctor(doctorId)) {
            System.out.println("✅ Doctor deactivated");
        } else {
            System.out.println("❌ Deactivation failed");
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Doctor;
import util.DBConnection;

public class DoctorDAO {

    // Add Doctor
    public boolean addDoctor(Doctor d) {
        String sql = "INSERT INTO doctors(name, specialty_id, contact, consultation_fee) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setInt(2, d.getSpecialtyId());
            ps.setString(3, d.getContact());
            ps.setDouble(4, d.getConsultationFee());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // View Doctors by Specialty (JOIN)
    public void viewDoctorsBySpecialty(String specialtyName) {

        String sql = "SELECT d.doctor_id, d.name, s.specialty_name, d.consultation_fee " +
                     "FROM doctors d " +
                     "JOIN specialties s ON d.specialty_id = s.specialty_id " +
                     "WHERE s.specialty_name = ? AND d.is_active = true";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, specialtyName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("doctor_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("specialty_name") + " | Fee: " +
                        rs.getDouble("consultation_fee")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Specialty
    public boolean updateSpecialty(int doctorId, int specialtyId) {
        String sql = "UPDATE doctors SET specialty_id = ? WHERE doctor_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ps.setInt(2, doctorId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Soft Delete (Deactivate)
    public boolean deactivateDoctor(int doctorId) {
        String sql = "UPDATE doctors SET is_active = false WHERE doctor_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Patient;
import util.DBConnection;

public class PatientDAO {

    // Check if phone or email already exists
    public boolean isPatientExists(String phone, String email) {
        String sql = "SELECT COUNT(*) FROM patients WHERE phone = ? OR email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setString(2, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Insert patient
    public boolean addPatient(Patient p) {
        String sql = "INSERT INTO patients(name, dob, phone, email, address, blood_group) VALUES (?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDate(2, p.getDob());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getBloodGroup());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
 // Search by ID or Phone (exact match)
    public Patient findByIdOrPhone(String input) {
        String sql = "SELECT * FROM patients WHERE patient_id = ? OR phone = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, input);
            ps.setString(2, input);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Search by Name (LIKE)
    public void findByName(String name) {
        String sql = "SELECT * FROM patients WHERE name LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("patient_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean updatePatient(Patient p) {
        String sql = "UPDATE patients SET address = ?, phone = ?, email = ? WHERE patient_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getAddress());
            ps.setString(2, p.getPhone());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getPatientId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}

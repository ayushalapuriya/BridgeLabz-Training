package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class VisitDAO {

    public boolean recordVisit(int appointmentId,
                               String diagnosis,
                               String notes,
                               java.util.List<model.Prescription> prescriptions) {

        String visitSQL = "INSERT INTO visits(appointment_id, diagnosis, notes) VALUES (?, ?, ?)";
        String prescriptionSQL = "INSERT INTO prescriptions(visit_id, medicine_name, dosage, duration) VALUES (?, ?, ?, ?)";
        String updateAppointmentSQL = "UPDATE appointments SET status = 'COMPLETED' WHERE appointment_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            // 1️⃣ Insert Visit
            PreparedStatement visitPs =
                    con.prepareStatement(visitSQL, PreparedStatement.RETURN_GENERATED_KEYS);

            visitPs.setInt(1, appointmentId);
            visitPs.setString(2, diagnosis);
            visitPs.setString(3, notes);
            visitPs.executeUpdate();

            ResultSet rs = visitPs.getGeneratedKeys();
            rs.next();
            int visitId = rs.getInt(1);

            // 2️⃣ Batch Insert Prescriptions
            PreparedStatement presPs = con.prepareStatement(prescriptionSQL);

            for (model.Prescription p : prescriptions) {
                presPs.setInt(1, visitId);
                presPs.setString(2, p.getMedicineName());
                presPs.setString(3, p.getDosage());
                presPs.setString(4, p.getDuration());
                presPs.addBatch();
            }

            presPs.executeBatch();

            // 3️⃣ Update Appointment Status
            PreparedStatement updatePs = con.prepareStatement(updateAppointmentSQL);
            updatePs.setInt(1, appointmentId);
            updatePs.executeUpdate();

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // View Medical History (JOIN)
    public void viewMedicalHistory(int patientId) {

        String sql = "SELECT v.visit_id, v.visit_date, d.name AS doctor, v.diagnosis " +
                     "FROM visits v " +
                     "JOIN appointments a ON v.appointment_id = a.appointment_id " +
                     "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                     "WHERE a.patient_id = ? " +
                     "ORDER BY v.visit_date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("visit_id") + " | " +
                        rs.getString("visit_date") + " | " +
                        rs.getString("doctor") + " | " +
                        rs.getString("diagnosis")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

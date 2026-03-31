package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Appointment;
import util.DBConnection;

public class AppointmentDAO {

    // Check availability
    public boolean isDoctorAvailable(int doctorId, String date, String time) {

        String sql = "SELECT COUNT(*) FROM appointments " +
                     "WHERE doctor_id = ? AND appointment_date = ? " +
                     "AND appointment_time = ? AND status = 'SCHEDULED'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setString(2, date);
            ps.setString(3, time);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0; // 0 means available
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Book appointment (TRANSACTION SAFE)
    public boolean bookAppointment(Appointment a) {

        String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setDate(3, a.getAppointmentDate());
            ps.setTime(4, a.getAppointmentTime());
            ps.setString(5, "SCHEDULED");

            ps.executeUpdate();

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cancel Appointment
    public boolean cancelAppointment(int appointmentId) {

        String sql = "UPDATE appointments SET status = 'CANCELLED' WHERE appointment_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // View Daily Schedule (JOIN)
    public void viewDailySchedule(String date) {

        String sql = "SELECT a.appointment_id, p.name AS patient, d.name AS doctor, a.appointment_time " +
                     "FROM appointments a " +
                     "JOIN patients p ON a.patient_id = p.patient_id " +
                     "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                     "WHERE a.appointment_date = ? " +
                     "ORDER BY a.appointment_time";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("appointment_id") + " | " +
                        rs.getString("patient") + " | " +
                        rs.getString("doctor") + " | " +
                        rs.getString("appointment_time")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

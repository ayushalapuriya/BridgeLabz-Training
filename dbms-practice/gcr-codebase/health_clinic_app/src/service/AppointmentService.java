package service;

import dao.AppointmentDAO;
import model.Appointment;

public class AppointmentService {

    private AppointmentDAO dao = new AppointmentDAO();

    public void bookAppointment(Appointment a, String date, String time) {

        if (!dao.isDoctorAvailable(a.getDoctorId(), date, time)) {
            System.out.println("❌ Doctor not available at this time");
            return;
        }

        if (dao.bookAppointment(a)) {
            System.out.println("✅ Appointment booked successfully");
        } else {
            System.out.println("❌ Booking failed");
        }
    }

    public void cancelAppointment(int id) {
        if (dao.cancelAppointment(id)) {
            System.out.println("✅ Appointment cancelled");
        } else {
            System.out.println("❌ Cancellation failed");
        }
    }

    public void viewSchedule(String date) {
        dao.viewDailySchedule(date);
    }
}

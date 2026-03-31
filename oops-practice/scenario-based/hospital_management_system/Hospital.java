package hospital_management_system;

import java.util.*;

public class Hospital implements HospitalService {

    private Map<Integer, Patient> patients = new HashMap<>();
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        System.out.println("Patient added: " + patient.getName());
    }

    @Override
    public void deletePatient(int patientId) {
        patients.remove(patientId);
        appointments.removeIf(a -> a.getPatient().getId() == patientId);
        System.out.println("Patient removed");
    }

    @Override
    public void bookAppointment(Appointment appointment)
            throws AppointmentNotAvailableException {

        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == appointment.getDoctor().getId()) {
                throw new AppointmentNotAvailableException(
                        "Doctor not available on this date"
                );
            }
        }
        appointments.add(appointment);
        System.out.println("Appointment booked successfully");
    }

    @Override
    public void cancelAppointment(int patientId) {
        appointments.removeIf(a -> a.getPatient().getId() == patientId);
        System.out.println("Appointment cancelled");
    }

    public void viewAllAppointments() {
        System.out.println("\nAppointments:");
        for (Appointment a : appointments) {
            a.displayAppointment();
            System.out.println();
        }
    }
}

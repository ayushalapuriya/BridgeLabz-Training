package hospital_management_system;

public interface HospitalService {
    void addPatient(Patient patient);
    void deletePatient(int patientId);
    void bookAppointment(Appointment appointment)
            throws AppointmentNotAvailableException;
    void cancelAppointment(int patientId);
}

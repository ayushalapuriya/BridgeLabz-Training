package hospital_management_system;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Patient p1 = new Patient(1, "Rahul", "9999999999");
        Patient p2 = new Patient(2, "Anita", "8888888888");

        Doctor d1 = new Doctor(101, "Dr Sharma", "7777777777", "General");
        Doctor d2 = new SpecialistDoctor(102, "Dr Mehta", "6666666666", "Cardiology");

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        p1.addMedicalRecord("Fever treatment");
        p1.addMedicalRecord("Blood test done");

        try {
            Appointment a1 = new Appointment(p1, d1, "10-Oct-2026");
            Appointment a2 = new Appointment(p2, d2, "11-Oct-2026");

            hospital.bookAppointment(a1);
            hospital.bookAppointment(a2);

            // Exception case
            hospital.bookAppointment(
                    new Appointment(p2, d1, "10-Oct-2026")
            );

        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        hospital.viewAllAppointments();

        p1.viewMedicalHistory();

        hospital.cancelAppointment(1);
        hospital.deletePatient(2);

        hospital.viewAllAppointments();
    }
}

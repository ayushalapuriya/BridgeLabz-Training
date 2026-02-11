package main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Prescription;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;
import service.VisitService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();

//        System.out.println("=== Patient Registration ===");
//
//        Patient p = new Patient();
//
//        System.out.print("Name: ");
//        p.setName(sc.nextLine());
//
//        System.out.print("DOB (yyyy-mm-dd): ");
//        p.setDob(Date.valueOf(sc.nextLine()));
//
//        System.out.print("Phone: ");
//        p.setPhone(sc.nextLine());
//
//        System.out.print("Email: ");
//        p.setEmail(sc.nextLine());
//
//        System.out.print("Address: ");
//        p.setAddress(sc.nextLine());
//
//        System.out.print("Blood Group: ");
//        p.setBloodGroup(sc.nextLine());

//        service.registerPatient(p);
        
//        System.out.print("Enter Patient ID or Phone to search: ");
//        String input = sc.nextLine();
//
//        Patient found = service.searchPatient(input);
//        if (found != null) {
//            System.out.println("Found: " + found.getName() + " | " + found.getPhone());
//        } else {
//            System.out.println("❌ Patient not found");
//        }
        
//        System.out.print("Enter Patient ID to update: ");
//        int id = Integer.parseInt(sc.nextLine());
//
//        Patient p = service.searchPatient(String.valueOf(id));
//        if (p == null) {
//            System.out.println("❌ Patient not found");
//            return;
//        }
//
//        System.out.print("New Address: ");
//        p.setAddress(sc.nextLine());
//
//        System.out.print("New Phone: ");
//        p.setPhone(sc.nextLine());
//
//        System.out.print("New Email: ");
//        p.setEmail(sc.nextLine());
//
//        service.updatePatient(p);
//
//
//        sc.close();
        
//        DoctorService doctorService = new DoctorService();
//        Doctor d = new Doctor();
//
//        System.out.print("Doctor Name: ");
//        d.setName(sc.nextLine());
//
//        System.out.print("Specialty ID: ");
//        d.setSpecialtyId(Integer.parseInt(sc.nextLine()));
//
//        System.out.print("Contact: ");
//        d.setContact(sc.nextLine());
//
//        System.out.print("Consultation Fee: ");
//        d.setConsultationFee(Double.parseDouble(sc.nextLine()));
//
//        doctorService.addDoctor(d);
        
//        AppointmentService service1 = new AppointmentService();
//        Appointment a = new Appointment();
//
//        System.out.print("Patient ID: ");
//        a.setPatientId(Integer.parseInt(sc.nextLine()));
//
//        System.out.print("Doctor ID: ");
//        a.setDoctorId(Integer.parseInt(sc.nextLine()));
//
//        System.out.print("Date (yyyy-mm-dd): ");
//        String date = sc.nextLine();
//        a.setAppointmentDate(java.sql.Date.valueOf(date));
//
//        System.out.print("Time (HH:MM:SS): ");
//        String time = sc.nextLine();
//        a.setAppointmentTime(java.sql.Time.valueOf(time));
//
//        service1.bookAppointment(a, date, time);


        VisitService service1 = new VisitService();
        List<Prescription> list = new ArrayList<>();

        System.out.print("Appointment ID: ");
        int appId = Integer.parseInt(sc.nextLine());

        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();

        System.out.print("Notes: ");
        String notes = sc.nextLine();

        // Add 2 medicines manually for testing
        Prescription p1 = new Prescription();
        p1.setMedicineName("Paracetamol");
        p1.setDosage("500mg");
        p1.setDuration("5 days");
        list.add(p1);

        Prescription p2 = new Prescription();
        p2.setMedicineName("Antibiotic");
        p2.setDosage("250mg");
        p2.setDuration("7 days");
        list.add(p2);

        service1.recordVisit(appId, diagnosis, notes, list);

        
    }
}

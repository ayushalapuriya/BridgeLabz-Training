package hospital_management_system;

public class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, String phone, String specialization) {
        super(id, name, phone);
        this.specialization = specialization;
    }

    public double calculateConsultationFee() {
        return 500;
    }

    public String getSpecialization() {
        return specialization;
    }
}

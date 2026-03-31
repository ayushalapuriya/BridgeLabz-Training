package hospital_management_system;

public class SpecialistDoctor extends Doctor {

    public SpecialistDoctor(int id, String name, String phone, String specialization) {
        super(id, name, phone, specialization);
    }

    @Override
    public double calculateConsultationFee() {
        return 1000;
    }
}

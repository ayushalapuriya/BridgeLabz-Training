package aidriven_resume_screening_system;

public class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public void processResume() {
        System.out.println(candidateName + " applying for " + role.getRoleName());
    }
}

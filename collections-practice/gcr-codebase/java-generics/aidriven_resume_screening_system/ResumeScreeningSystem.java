package aidriven_resume_screening_system;

import java.util.List;

public class ResumeScreeningSystem {
    public static void screenCandidates(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resumes for " + role.getRoleName());
        }
    }
}

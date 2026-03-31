package aidriven_resume_screening_system;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 =
                new Resume<>("Alice", new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>("Bob", new DataScientist());

        r1.processResume();
        r2.processResume();

        List<JobRole> roles = Arrays.asList(
                new SoftwareEngineer(),
                new DataScientist(),
                new ProductManager()
        );

        ResumeScreeningSystem.screenCandidates(roles);
    }
}

package student_course_management_system;

public interface RegistrationService {
    void enrollCourse(Course course) throws CourseLimitExceededException;
    void dropCourse(String courseCode);
}

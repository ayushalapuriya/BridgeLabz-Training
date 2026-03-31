package student_course_management_system;

public class GradeManagement {
    public void assignGrade(Student student, String courseCode, String grade) {
        student.updateGrade(courseCode, grade);
        System.out.println("✅ Grade Assigned");
    }
}

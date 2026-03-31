package student_course_management_system;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void displayCourseDetails() {
        System.out.println("\nCourse Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Enrolled Students:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("- " + s.getName());
            }
        }
    }
}

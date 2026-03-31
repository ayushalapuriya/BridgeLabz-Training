package student_course_management_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student extends Person implements RegistrationService {

    private List<Course> courses;
    private Map<String, String> grades;
    private static final int MAX_COURSES = 3;

    public Student(int roll, String name, String phoneNo) {
        super(roll, name, phoneNo);
        courses = new ArrayList<>();
        grades = new HashMap<>();
    }

    @Override
    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public void dropCourse(String courseCode) {
        Course removeCourse = null;
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                removeCourse = c;
                break;
            }
        }
        if (removeCourse != null) {
            courses.remove(removeCourse);
            removeCourse.removeStudent(this);
            grades.remove(courseCode);
        }
    }

    public void updateCourse(String oldCourseCode, Course newCourse) throws CourseLimitExceededException {
        dropCourse(oldCourseCode);
        enrollCourse(newCourse);
    }

    public void updateGrade(String courseCode, String grade) {
        grades.put(courseCode, grade);
    }

    public void displayStudentDetails() {
        System.out.println("\nStudent Details");
        displayPersonDetails();

        System.out.println("\nCourses Enrolled:");
        for (Course c : courses) {
            System.out.println(c.getCourseCode() + " - " + c.getCourseName());
        }

        System.out.println("\nGrades:");
        if (grades.isEmpty()) {
            System.out.println("No grades assigned");
        } else {
            for (String code : grades.keySet()) {
                System.out.println(code + " : " + grades.get(code));
            }
        }
    }
}

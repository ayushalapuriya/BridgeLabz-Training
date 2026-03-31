package student_course_management_system;

import java.util.*;

public class StudentCourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = null;
        Map<String, Course> courseMap = new HashMap<>();
        GradeManagement gradeManager = new GradeManagement();

        int choice;

        do {
            System.out.println("\n===== STUDENT COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Course");
            System.out.println("4. Drop Course");
            System.out.println("5. Update Course");
            System.out.println("6. Assign Grade");
            System.out.println("7. Display Student Details");
            System.out.println("8. Display Course Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter roll: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();

                        student = new Student(roll, name, phone);
                        System.out.println("Student added successfully");
                        break;

                    case 2:
                        System.out.print("Enter course code: ");
                        String code = sc.next();

                        sc.nextLine();
                        System.out.print("Enter course name: ");
                        String cname = sc.nextLine();

                        courseMap.put(code, new Course(code, cname));
                        System.out.println("Course added successfully");
                        break;

                    case 3:
                        if (student == null) {
                            System.out.println("Add student first");
                            break;
                        }
                        System.out.print("Enter course code to enroll: ");
                        String enrollCode = sc.next();

                        Course enrollCourse = courseMap.get(enrollCode);
                        if (enrollCourse != null) {
                            student.enrollCourse(enrollCourse);
                            System.out.println("Course enrolled");
                        } else {
                            System.out.println("Course not found");
                        }
                        break;

                    case 4:
                        if (student == null) {
                            System.out.println("Add student first");
                            break;
                        }
                        System.out.print("Enter course code to drop: ");
                        String dropCode = sc.next();
                        student.dropCourse(dropCode);
                        System.out.println("Course dropped");
                        break;

                    case 5:
                        if (student == null) {
                            System.out.println("Add student first");
                            break;
                        }
                        System.out.print("Enter old course code: ");
                        String oldCode = sc.next();

                        System.out.print("Enter new course code: ");
                        String newCode = sc.next();

                        Course newCourse = courseMap.get(newCode);
                        if (newCourse != null) {
                            student.updateCourse(oldCode, newCourse);
                            System.out.println("Course updated");
                        } else {
                            System.out.println("New course not found");
                        }
                        break;

                    case 6:
                        if (student == null) {
                            System.out.println("Add student first");
                            break;
                        }
                        System.out.print("Enter course code: ");
                        String gradeCode = sc.next();

                        System.out.print("Enter grade: ");
                        String grade = sc.next();

                        gradeManager.assignGrade(student, gradeCode, grade);
                        System.out.println("Grade assigned");
                        break;

                    case 7:
                        if (student != null) {
                            student.displayStudentDetails();
                        } else {
                            System.out.println("No student available");
                        }
                        break;

                    case 8:
                        System.out.print("Enter course code: ");
                        String viewCode = sc.next();

                        Course viewCourse = courseMap.get(viewCode);
                        if (viewCourse != null) {
                            viewCourse.displayCourseDetails();
                        } else {
                            System.out.println("Course not found");
                        }
                        break;

                    case 0:
                        System.out.println("System exited");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (CourseLimitExceededException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}

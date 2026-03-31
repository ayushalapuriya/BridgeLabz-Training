package multilevel_university_coure;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Course<ExamCourse> c1 =
                new Course<>("Data Structures", new ExamCourse());

        Course<AssignmentCourse> c2 =
                new Course<>("Software Engineering", new AssignmentCourse());

        c1.showCourseDetails();
        c2.showCourseDetails();

        List<CourseType> courseTypes = Arrays.asList(
                new ExamCourse(),
                new AssignmentCourse(),
                new ResearchCourse()
        );

        CourseManager.displayEvaluationMethods(courseTypes);
    }
}

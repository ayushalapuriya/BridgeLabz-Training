package multilevel_university_coure;

import java.util.List;

public class CourseManager {
    public static void displayEvaluationMethods(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getEvaluationType());
        }
    }
}

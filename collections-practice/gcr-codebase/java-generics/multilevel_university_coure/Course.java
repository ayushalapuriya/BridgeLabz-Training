package multilevel_university_coure;

public class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void showCourseDetails() {
        System.out.println(courseName + " - " + courseType.getEvaluationType());
    }
}

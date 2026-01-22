package multilevel_university_coure;

abstract class CourseType {
    abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    String getEvaluationType() {
        return "Exam Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    String getEvaluationType() {
        return "Assignment Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    String getEvaluationType() {
        return "Research Based Evaluation";
    }
}

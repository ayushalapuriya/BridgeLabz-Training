package online_examination_system;

public class OnlineExaminationSystem {

    public static void main(String[] args) {

        EvaluationStrategy objectiveEval = new ObjectiveEvaluation();
        EvaluationStrategy descriptiveEval = new DescriptiveEvaluation();

        Exam objectiveExam = new Exam("Java Objective Test", objectiveEval);
        Exam descriptiveExam = new Exam("Java Descriptive Test", descriptiveEval);

        Question q1 = new Question(1, "What is JVM?", "Java Virtual Machine", 5);
        Question q2 = new Question(2, "What is OOP?", "Object Oriented Programming", 5);

        objectiveExam.addQuestion(q1);
        descriptiveExam.addQuestion(q2);

        Student student = new Student(101, "Aman");

        try {
            student.submitAnswer(q1, "Java Virtual Machine");
            student.submitAnswer(q2,
                    "OOP is a programming paradigm based on objects and classes");

            // Exception case
            student.submitAnswer(q2, null);

        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }

        int objectiveScore = objectiveExam.evaluateResult(student);
        int descriptiveScore = descriptiveExam.evaluateResult(student);

        System.out.println("\nStudent: " + student.getName());
        System.out.println("Objective Exam Score  : " + objectiveScore);
        System.out.println("Descriptive Exam Score: " + descriptiveScore);
    }
}

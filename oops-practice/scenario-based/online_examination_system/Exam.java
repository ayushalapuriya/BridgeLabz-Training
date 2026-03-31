package online_examination_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exam {
    private String examName;
    private List<Question> questions = new ArrayList<>();
    private EvaluationStrategy evaluationStrategy;

    public Exam(String examName, EvaluationStrategy evaluationStrategy) {
        this.examName = examName;
        this.evaluationStrategy = evaluationStrategy;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int evaluateResult(Student student) {
        int totalMarks = 0;
        for (Map.Entry<Question, String> entry : student.getAnswers().entrySet()) {
            totalMarks += evaluationStrategy.evaluate(
                    entry.getKey(), entry.getValue()
            );
        }
        return totalMarks;
    }

    public void displayExamDetails() {
        System.out.println("Exam: " + examName);
        for (Question q : questions) {
            System.out.println("- " + q.getQuestionText());
        }
    }
}

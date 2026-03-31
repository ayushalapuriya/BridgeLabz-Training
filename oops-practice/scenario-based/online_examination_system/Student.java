package online_examination_system;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String name;
    private Map<Question, String> answers = new HashMap<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void submitAnswer(Question question, String answer)
            throws ExamTimeExpiredException {

        if (answer == null) {
            throw new ExamTimeExpiredException(
                    "Exam time expired. Cannot submit answer."
            );
        }
        answers.put(question, answer);
    }

    public Map<Question, String> getAnswers() {
        return answers;
    }

    public String getName() {
        return name;
    }
}

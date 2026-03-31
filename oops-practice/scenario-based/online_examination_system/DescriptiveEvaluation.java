package online_examination_system;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String answer) {
        if (answer != null && answer.length() > 10) {
            return question.getMarks();
        }
        return question.getMarks() / 2;
    }
}

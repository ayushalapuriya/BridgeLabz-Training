package online_examination_system;

public class Question {
    private int id;
    private String questionText;
    private String correctAnswer;
    private int marks;

    public Question(int id, String questionText, String correctAnswer, int marks) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public String getQuestionText() {
        return questionText;
    }
}

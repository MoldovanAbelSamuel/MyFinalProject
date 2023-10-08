package FinalProject.org.drivingTest.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "QuestionAnswer")
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionAnswerId;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    private boolean correctAnswer;

    public QuestionAnswer(int questionAnswerId, Question question, Answer answer, boolean correctAnswer) {
        this.questionAnswerId = questionAnswerId;
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public QuestionAnswer(Question question, Answer answer, boolean correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public QuestionAnswer() {
    }

    public int getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(int questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

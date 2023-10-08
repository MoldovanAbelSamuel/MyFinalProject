package FinalProject.org.drivingTest.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    private String questionText;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionAnswer> questionAnswers;

    @ManyToOne
    private Questionnaire questionnaire;

    public Question(int questionId, String questionText, List<QuestionAnswer> questionAnswers, Questionnaire questionnaire) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionAnswers = questionAnswers;
        this.questionnaire = questionnaire;
    }

    public Question(String questionText, List<QuestionAnswer> questionAnswers, Questionnaire questionnaire) {
        this.questionText = questionText;
        this.questionAnswers = questionAnswers;
        this.questionnaire = questionnaire;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}

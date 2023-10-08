package FinalProject.org.drivingTest.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionnaireId;

    private String title;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Questionnaire(int questionnaireId, String title, List<Question> questions) {
        this.questionnaireId = questionnaireId;
        this.title = title;
        this.questions = questions;
    }

    public Questionnaire(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Questionnaire() {
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

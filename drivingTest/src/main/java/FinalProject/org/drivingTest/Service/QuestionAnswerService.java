package FinalProject.org.drivingTest.Service;

import FinalProject.org.drivingTest.Model.QuestionAnswer;
import FinalProject.org.drivingTest.Repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAnswerService {

    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public QuestionAnswerService(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    public List<QuestionAnswer> getQuestionsAndAnswers(){
        return this.questionAnswerRepository.findAll();
    }

    public QuestionAnswer addQuestionAndAnswer(QuestionAnswer questionAnswer){
        return this.questionAnswerRepository.save(questionAnswer);
    }
}

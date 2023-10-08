package FinalProject.org.drivingTest.Service;

import FinalProject.org.drivingTest.Model.Answer;
import FinalProject.org.drivingTest.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAnswers(){
        return this.answerRepository.findAll();
    }

    public Answer addAnswer(Answer answer){
        return this.answerRepository.save(answer);
    }
}

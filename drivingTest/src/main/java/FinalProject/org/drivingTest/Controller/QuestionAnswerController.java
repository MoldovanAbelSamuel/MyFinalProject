package FinalProject.org.drivingTest.Controller;

import FinalProject.org.drivingTest.Model.Answer;
import FinalProject.org.drivingTest.Model.QuestionAnswer;
import FinalProject.org.drivingTest.Service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionAnswer")
public class QuestionAnswerController {

    private QuestionAnswerService questionAnswerService;

    @Autowired
    public QuestionAnswerController(QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionAnswer>> getQuestionsAndAnswers() {
        List<QuestionAnswer> questionAnswers = questionAnswerService.getQuestionsAndAnswers();
        if (!questionAnswers.isEmpty()) {
            return ResponseEntity.ok(questionAnswers);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping
    public ResponseEntity<QuestionAnswer> addQuestionAndAnswer(@RequestBody QuestionAnswer questionAnswer){
        QuestionAnswer addedQuestionAnswer = questionAnswerService.addQuestionAndAnswer(questionAnswer);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedQuestionAnswer);
    }
}

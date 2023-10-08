package FinalProject.org.drivingTest.Controller;

import FinalProject.org.drivingTest.Model.Answer;
import FinalProject.org.drivingTest.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answer")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answers = answerService.getAnswers();
        if (!answers.isEmpty()) {
            return ResponseEntity.ok(answers);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
        Answer addedAnswer = answerService.addAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAnswer);
    }
}

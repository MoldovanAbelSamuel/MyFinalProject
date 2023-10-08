package FinalProject.org.drivingTest.Controller;


import FinalProject.org.drivingTest.Model.Question;
import FinalProject.org.drivingTest.Model.Questionnaire;
import FinalProject.org.drivingTest.Service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionnaire")
public class QuestionnaireController {
    private QuestionnaireService questionnaireService;
    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping
    public ResponseEntity<List<Questionnaire>> getQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
        if (!questionnaires.isEmpty()) {
            return ResponseEntity.ok(questionnaires);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping
    public ResponseEntity<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire){
        Questionnaire addedQuestionnaire = questionnaireService.addQuestionnaire(questionnaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedQuestionnaire);
    }
}

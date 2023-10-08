package FinalProject.org.drivingTest.Repository;

import FinalProject.org.drivingTest.Model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {
}

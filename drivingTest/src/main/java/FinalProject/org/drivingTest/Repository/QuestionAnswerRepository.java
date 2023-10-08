package FinalProject.org.drivingTest.Repository;

import FinalProject.org.drivingTest.Model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Integer> {
}

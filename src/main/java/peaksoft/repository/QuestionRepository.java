package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
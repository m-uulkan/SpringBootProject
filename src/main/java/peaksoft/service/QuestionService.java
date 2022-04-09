package peaksoft.service;

import peaksoft.dto.QuestionRequest;
import peaksoft.dto.response.QuestionResponse;
import peaksoft.model.Question;

import java.util.List;

public interface QuestionService {
    QuestionResponse saveQuestion(QuestionRequest questionRequest);

    QuestionResponse update(Long id, QuestionRequest questionRequest);

    List<Question> getAllQuestion(List<Question> questions);

    void deleteQuestionById(Long id);

    Question getQuestionById(Long id);

}

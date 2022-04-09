package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.QuestionRequest;
import peaksoft.dto.response.QuestionResponse;
import peaksoft.mapper.QuestionMapper;
import peaksoft.model.Question;
import peaksoft.repository.QuestionRepository;
import peaksoft.service.QuestionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImple implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;


    @Override
    public QuestionResponse saveQuestion(QuestionRequest questionRequest) {
        return questionMapper.viewQuestion(questionRepository
                .save(questionMapper
                        .create(questionRequest)));
    }

    @Override
    public QuestionResponse update(Long id, QuestionRequest questionRequest) {
        return null;
    }

    @Override
    public List<Question> getAllQuestion(List<Question> questions) {
        return null;
    }

    @Override
    public void deleteQuestionById(Long id) {

    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).get();
    }
}

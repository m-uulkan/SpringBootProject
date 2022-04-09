package peaksoft.mapper;


import org.springframework.stereotype.Component;
import peaksoft.dto.QuestionRequest;
import peaksoft.dto.response.QuestionResponse;
import peaksoft.model.Question;

@Component
public class QuestionMapper {

    public Question create(QuestionRequest questionRequest){
        Question question=new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setTest(questionRequest.getTest());
        return question;
    }

    public QuestionResponse viewQuestion(Question question){
        QuestionResponse questionResponse=new QuestionResponse();
        if(question.getId()!=null){
         questionResponse.setId(String.valueOf(question.getId()));
        }
        questionResponse.setQuestion(question.getQuestion());
        return  questionResponse;
    }
}

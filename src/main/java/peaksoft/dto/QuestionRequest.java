package peaksoft.dto;


import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Test;

@Getter
@Setter
public class QuestionRequest {
    private String question;
    private Test test;
}

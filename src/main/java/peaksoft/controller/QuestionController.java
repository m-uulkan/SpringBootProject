package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.QuestionRequest;
import peaksoft.dto.response.QuestionResponse;
import peaksoft.mapper.QuestionMapper;
import peaksoft.model.Question;
import peaksoft.service.serviceImple.QuestionServiceImple;
import peaksoft.service.serviceImple.TestServiceImple;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question/{id}")
@PreAuthorize("hasAuthority('ADMIN')")
public class QuestionController {

    private final QuestionServiceImple questionService;
    private final TestServiceImple testService;

    @PostMapping("/create")
    public QuestionResponse createQuestion(@RequestBody QuestionRequest questionRequest,
                                           @PathVariable("id")Long id){
        questionRequest.setTest(testService.getTestById(id));
        return questionService.saveQuestion(questionRequest);
    }
}

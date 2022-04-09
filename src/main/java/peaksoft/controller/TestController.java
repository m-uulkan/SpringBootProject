package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.type.ListType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.TestRequest;
import peaksoft.dto.response.TestResponse;
import peaksoft.mapper.TestMapper;
import peaksoft.model.Test;
import peaksoft.service.serviceImple.QuestionServiceImple;
import peaksoft.service.serviceImple.TestServiceImple;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
//@PreAuthorize("hasAuthority('ADMIN')")
public class TestController {

    private final TestServiceImple testService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public TestResponse createTest(@RequestBody TestRequest testRequest){
        return testService.saveTest(testRequest);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public Test getTest(@PathVariable("id")Long id){
        return testService.getTestById(id);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/all")
    public List<TestResponse> getTests(@RequestBody List<Test>tests){
        return testService.getAllTest(tests);
    }
}

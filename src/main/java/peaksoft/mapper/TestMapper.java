package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.TestRequest;
import peaksoft.dto.response.TestResponse;
import peaksoft.model.Test;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestMapper {

    public Test create(TestRequest testRequest) {
        Test test = new Test();
        test.setTestName(testRequest.getTestName());
        return test;
    }

    public TestResponse viewTest(Test test) {
        TestResponse testResponse = new TestResponse();
        if (test.getId() != null) {
            testResponse.setId(String.valueOf(test.getId()));
        }
        testResponse.setTestName(test.getTestName());
        return testResponse;

    }

    public List<TestResponse> viewTests(List<Test> testResponseList) {
        List<TestResponse>responses=new ArrayList<>();
            for(Test t:testResponseList){
                responses.add(viewTest(t));
        }
            return responses;
    }
}
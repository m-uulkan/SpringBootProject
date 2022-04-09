package peaksoft.service;


import peaksoft.dto.TestRequest;

import peaksoft.dto.response.TestResponse;

import peaksoft.model.Test;

import java.util.List;

public interface TestService {
    TestResponse saveTest(TestRequest testRequest);

    TestResponse update(Long id, TestRequest testRequest);

    List<TestResponse> getAllTest(List<Test>tests);

    void deleteTestById(Long id);

    Test getTestById(Long id);
}

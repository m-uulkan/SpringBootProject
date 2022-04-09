package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.TestRequest;
import peaksoft.dto.response.TestResponse;
import peaksoft.mapper.TestMapper;
import peaksoft.model.Test;
import peaksoft.repository.TestRepository;
import peaksoft.service.TestService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TestServiceImple implements TestService {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public TestResponse saveTest(TestRequest testRequest) {
        return testMapper.viewTest(testRepository
                .save(testMapper
                        .create(testRequest)));
    }

    @Override
    public TestResponse update(Long id, TestRequest testRequest) {
        return null;
    }

    @Override
    public List<TestResponse> getAllTest(List<Test> tests) {
        List<Test>testResponseList=testRepository.findAll();
        return testMapper.viewTests(testResponseList);
    }

    @Override
    public void deleteTestById(Long id) {
    }

    @Override
    public Test getTestById(Long id) {
        return testRepository.findById(id).get();
    }
}

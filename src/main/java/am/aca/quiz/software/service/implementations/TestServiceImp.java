package am.aca.quiz.software.service.implementations;

import am.aca.quiz.software.entity.TestEntity;
import am.aca.quiz.software.repository.TestRepository;
import am.aca.quiz.software.service.interfaces.TestService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TestServiceImp implements TestService {


    private final TestRepository testRepository;

    public TestServiceImp(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public boolean addTest(String testName, String description, long duration) throws SQLException {
        TestEntity testEntity=new TestEntity(testName,duration,description);
        testRepository.saveAndFlush(testEntity);
        return true;
    }

    @Override
    public List<TestEntity> getAll() throws SQLException {
        return testRepository.findAll();
    }

    @Override
    public boolean update(TestEntity test, Long id) throws SQLException {
        TestEntity testEntity = testRepository.findById(id).get();
        if (testEntity != null) {
            test.setId(id);
            testRepository.saveAndFlush(test);
            return true;
        }
        return false;
    }


    @Override
    public boolean removeById(Long id) throws SQLException {
        testRepository.deleteById(id);
        return true;
    }

    @Override
    public TestEntity getById(Long id) throws SQLException {
        return testRepository.findById(id).get();
    }
}

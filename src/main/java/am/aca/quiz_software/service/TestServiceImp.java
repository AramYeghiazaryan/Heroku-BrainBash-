package am.aca.quiz_software.service;

import am.aca.quiz_software.entity.TestEntity;
import am.aca.quiz_software.repository.HistoryRepository;
import am.aca.quiz_software.repository.QuestionRepository;
import am.aca.quiz_software.repository.TestRepository;
import am.aca.quiz_software.service.dto.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class TestServiceImp implements TestService {

    @Autowired
    private  TestRepository testRepository;

    public boolean addCategory(TestEntity test) throws SQLException {
        testRepository.saveAndFlush(test);
        return true;
    }

    public List<TestEntity> getAll() throws SQLException {
        return testRepository.findAll();
    }

    public boolean update(TestEntity test) throws SQLException {
        //toDO
        return false;
    }

    public TestEntity remove(TestEntity test) throws SQLException {
        testRepository.delete(test);
        return test;
    }
}

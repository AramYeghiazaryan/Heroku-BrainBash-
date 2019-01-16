package am.aca.quiz_software.service;

import am.aca.quiz_software.entity.TopicEntity;
import am.aca.quiz_software.repository.QuestionRepository;
import am.aca.quiz_software.repository.ScoreRepository;
import am.aca.quiz_software.repository.SubCategoryRepository;
import am.aca.quiz_software.repository.TopicRepository;
import am.aca.quiz_software.service.dto.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class TopicServiceImp implements TopicService {

    @Autowired
    private  TopicRepository topicRepository;

    public boolean addCategory(TopicEntity topic) throws SQLException {
        topicRepository.saveAndFlush(topic);
        return true;
    }

    public List<TopicEntity> getAll() throws SQLException {
        return topicRepository.findAll();
    }

    public boolean update(TopicEntity topic) throws SQLException {
        //toDO
        return false;
    }

    public TopicEntity remove(TopicEntity topic) throws SQLException {
        topicRepository.delete(topic);
        return topic;
    }
}

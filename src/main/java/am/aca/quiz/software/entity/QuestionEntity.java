package am.aca.quiz.software.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question",nullable = false,columnDefinition = "text")
    private String question;

    @Min(value = 0,message = "Invalid Point Argument. Points must be >= 0")
    @Column(name = "points",nullable = false)
    private int points;

    @Enumerated(EnumType.STRING)
    @Column (name = "level",nullable = false)
    private Level level;

    @Min(value = 1,message = "The question must have at least one correct answer")
    @Column (name = "correct_answer_count",nullable = false)
    private int correct_amount;

    @OneToMany(mappedBy = "questionEntity",cascade = CascadeType.ALL)
    private List<AnswerEntity> answerEntities=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_test",
            joinColumns = {@JoinColumn(name = "question_id",insertable = false,updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "test_id",insertable = false,updatable = false)})
    private List<TestEntity> testEntities=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private TopicEntity topicEntity;

    public QuestionEntity(String question, Enum level, int correctAnswerCount, int points, TopicEntity topicEntity) {
    }

    public QuestionEntity(String question, @Min(value = 0, message = "Invalid Point Argument. Points must be >= 0") int points, Level level, @Min(value = 1, message = "The question must have at least one correct answer") int correct_amount, TopicEntity topicEntity) {
        this.question = question;
        this.points = points;
        this.level = level;
        this.correct_amount = correct_amount;
        this.topicEntity = topicEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getCorrect_amount() {
        return correct_amount;
    }

    public void setCorrect_amount(int correct_amount) {
        this.correct_amount = correct_amount;
    }

    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }

    public List<TestEntity> getTestEntities() {
        return testEntities;
    }

    public void setTestEntities(List<TestEntity> testEntities) {
        this.testEntities = testEntities;
    }

    public TopicEntity getTopicEntity() {
        return topicEntity;
    }

    public void setTopicEntity(TopicEntity topicEntity) {
        this.topicEntity = topicEntity;
    }

    public enum Level {
        BEGINNER("beginner"),
        INTERMEDIATE("intermediate"),
        ADVANCED("advanced");

        private final String stringValue;

        Level(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

}


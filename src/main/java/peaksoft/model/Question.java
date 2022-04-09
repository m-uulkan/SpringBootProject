package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="questions")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
    private List<Answer>options;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="test_id")
    @JsonIgnore
    private Test test;

    public void setTestToQuestion(Test test){
        this.test=test;
        test.setQuestionToTest(this);
    }

}

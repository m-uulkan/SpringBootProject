package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tests")
@Getter
@Setter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="test_name")
    private String testName;
//    private String duration;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "test",fetch=FetchType.EAGER)
    private List<Question>questionList=new ArrayList<>();

    public void setQuestionToTest(Question question){
       questionList.add(question);
    }
}

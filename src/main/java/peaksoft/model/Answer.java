package peaksoft.model;

import javax.persistence.*;

@Entity
@Table(name="answers")

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String option;
   private boolean isCorrectAnswer;

   @ManyToOne(cascade=CascadeType.ALL)//кроме remove
   @JoinColumn(name="question_id")
   private Question question;

}

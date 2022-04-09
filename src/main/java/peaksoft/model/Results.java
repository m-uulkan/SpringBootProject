package peaksoft.model;

import javax.persistence.*;

@Entity
@Table(name="results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

package peaksoft.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_seq")
    @SequenceGenerator(name="role_seq",
            sequenceName = "role_seq",
            allocationSize = 1)
    private long id;
    private String name;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "role")
    private List<User>users;

    public void setUserToRole(User user){
        users.add(user);
    }
}

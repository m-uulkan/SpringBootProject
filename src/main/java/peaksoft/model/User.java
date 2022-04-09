package peaksoft.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_seq")
    @SequenceGenerator(name="user_seq",
            sequenceName = "user_seq",
            allocationSize = 1)
    private Long id;
    private String firstName;
    private String email;
    private String password;


    public User() {
    }

    public User(String firstName, String email, String password) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    @ManyToOne()
    @JoinColumn(name="role_id")
     private Role role;

    public void setRoleToUser(Role role){
       this.role=role;
       role.setUserToRole(this);
   }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority>granted=new ArrayList<>();
        List<Role>roles=new ArrayList<>();
        for(Role role:roles){
            granted.add(new SimpleGrantedAuthority(role.getName()));
        }
        return granted;
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

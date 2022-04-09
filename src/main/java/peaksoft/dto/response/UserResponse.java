package peaksoft.dto.response;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
public class UserResponse {
    private String id;
    private String firstName;
    private String email;
}

package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;

@Component
public class UserMapper {

    public User createUser(UserRequest userRequest) {
        User user=new User();
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return user;
    }

    public UserResponse viewUser(User user) {
        UserResponse userResponse=new UserResponse();
        if(user.getId()!=null){
          userResponse.setId(String.valueOf(user.getId()));
        }
        userResponse.setFirstName(user.getFirstName());
        userResponse.setEmail(user.getEmail());
            return userResponse;
    }
}

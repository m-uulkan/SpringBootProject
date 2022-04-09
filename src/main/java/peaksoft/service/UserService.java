package peaksoft.service;

import peaksoft.dto.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    UserResponse saveUser(UserRequest userRequest);
    Optional<User> findUserByEmail(String email);
    List<User> getAllUser();
    void deleteUserById(Long id);
    User saveAdmin(User user);
}

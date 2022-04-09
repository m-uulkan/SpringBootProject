package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.mapper.UserMapper;
import peaksoft.model.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImple implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleServiceImple roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;



    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user= userMapper.createUser(userRequest);
        user.setRoleToUser(roleService.findByName("USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.viewUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

    @Override
    public User saveAdmin(User user) {
        user.setRoleToUser(roleService.findByName("ADMIN"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).
                orElseThrow(() ->
                        new UsernameNotFoundException(format("User by email - %s not found", email)));

    }

}

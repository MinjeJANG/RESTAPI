package mj.project.eatgo.application;

import mj.project.eatgo.domain.User;
import mj.project.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {


    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password) {

        User user = User.builder()
                .email(email)
                .name(name)
                .password(password)
                .level(1L)
                .build();

        return userRepository.save(user);
    }
}

package mj.project.eatgo.application;

import mj.project.eatgo.domain.User;
import mj.project.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {

        List<User> users = userRepository.findAll();

        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        // TODO: restaurantService의 예외 처리 참고.
        User user = userRepository.findById(id).orElse(null);

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        userRepository.save(user);

        return user;
    }

    public User deactiveUser(long id) {

        User user = userRepository.findById(id).orElse(null);

        user.deactivate();
        return user;
    }
}

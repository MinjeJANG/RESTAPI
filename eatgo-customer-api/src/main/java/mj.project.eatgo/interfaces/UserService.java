package mj.project.eatgo.interfaces;

import mj.project.eatgo.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    public User registerUser(String email, String name, String password) {

        return null;
    }
}

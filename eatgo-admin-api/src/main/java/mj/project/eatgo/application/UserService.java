package mj.project.eatgo.application;

import mj.project.eatgo.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        users.add(User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(1L)
                .build());

        return users;
    }
}

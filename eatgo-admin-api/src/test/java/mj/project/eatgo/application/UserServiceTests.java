package mj.project.eatgo.application;

import mj.project.eatgo.domain.User;
import mj.project.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class UserServiceTests {

    private UserService userSerivce;

    @Mock
    private UserRepository userRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userSerivce = new UserService(userRepository);
    }

    @Test
    public void getUsers() {
        List<User> mockUsers = new ArrayList<>();

        mockUsers.add(User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(1L)
                .build());

        given(userRepository.findAll()).willReturn(mockUsers);
        List<User> users = userSerivce.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("테스터"));
    }

    @Test
    public void addUser() {

        String email = "admin@example.com";
        String name = "Administrator";
        User mockUser = User.builder()
                .email(email)
                .name(name)
                .build();

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userSerivce.addUser(email, name);

        assertThat(user.getName(), is(name));
    }

}
package mj.project.eatgo.application;

import mj.project.eatgo.application.UserService;
import mj.project.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class UserServiceTests {


    @Mock
    private UserRepository userRepository;
    private UserService userServicce;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userServicce = new UserService(userRepository);
    }


    @Test
    public void registerUser() {
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";
        userServicce.registerUser(email, name, password);

        verify(userRepository).save(any());
    }

}
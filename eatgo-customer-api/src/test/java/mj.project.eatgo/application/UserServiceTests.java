package mj.project.eatgo.application;

import mj.project.eatgo.domain.User;
import mj.project.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
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


    @Test(expected = EmailExistedException.class)
    public void registerUserWithExistedEmail() {

        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        User user = User.builder().build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));
        userServicce.registerUser(email, name, password);

        verify(userRepository, never()).save(any());
    }

}
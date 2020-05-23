package mj.project.eatgo.application;

import mj.project.eatgo.domain.RestaurantRepository;
import mj.project.eatgo.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class UserServiceTests {

    private UserService userSerivce;

    @Before
    public void setUp() {

        userSerivce = new UserService();
    }

    @Test
    public void getUsers() {
        List<User> mockUsers = new ArrayList<>();


        List<User> users = userSerivce.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("테스터"));
    }

}
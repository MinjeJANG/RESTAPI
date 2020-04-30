package mj.project.eatgo.application;

import mj.project.eatgo.domain.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.scripting.support.RefreshableScriptTargetSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuRepository menuRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockRestaurantRepository();
        mockMenuItemRepository();

        restaurantService = new RestaurantService(restaurantRepository, menuRepository);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));

        given(menuRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);

    }

    private void mockRestaurantRepository() {
        List<Restaurant> restauarants   = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L,  "Bob zip", "Seoul");
        restauarants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restauarants);

        given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);

        assertThat(restaurant.getId(), is(1004L));
    }

}
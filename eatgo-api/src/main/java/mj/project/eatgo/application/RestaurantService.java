package mj.project.eatgo.application;

import mj.project.eatgo.domain.MenuItem;
import mj.project.eatgo.domain.MenuRepository;
import mj.project.eatgo.domain.Restaurant;
import mj.project.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public List<Restaurant> getRestaurants() {

        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }
}

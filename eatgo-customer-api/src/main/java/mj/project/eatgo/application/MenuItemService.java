package mj.project.eatgo.application;

import mj.project.eatgo.domain.MenuItem;
import mj.project.eatgo.domain.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuItemService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {

        for(MenuItem menuItem : menuItems) {
            update(restaurantId, menuItem);
        }

    }

    private void update(Long restaurantId, MenuItem menuItem) {
        if (menuItem.isDestroy()) {
            menuRepository.deleteById(menuItem.getId());
            return;
        }

        menuItem.setRestaurantId(restaurantId);
        menuRepository.save(menuItem);
    }
}

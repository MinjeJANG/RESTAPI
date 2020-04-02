package mj.project.eatgo.domain;

import java.util.List;

public interface MenuRepository {

    List<MenuItem> findAllByRestaurantId(Long id);


}

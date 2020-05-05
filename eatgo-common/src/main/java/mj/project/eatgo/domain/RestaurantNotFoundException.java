package mj.project.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(long id) {
        super("Coul not find restaurant  " + id);
    }
}

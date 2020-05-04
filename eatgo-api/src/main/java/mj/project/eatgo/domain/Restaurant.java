package mj.project.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    @Setter
    private Long id;

    private String name;

    private String address;

    @Transient
    private List<MenuItem> menuItems;

    public String getInformation() {
        return name + " in " + address;
    }

    public void addMenuItem(MenuItem menuItem ) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);

    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

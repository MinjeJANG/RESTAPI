package mj.project.eatgo.application;

import mj.project.eatgo.domain.Category;
import mj.project.eatgo.domain.CategoryRepository;
import mj.project.eatgo.domain.Region;
import mj.project.eatgo.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {

        List<Category> categories = categoryRepository.findAll();

   /*     List<Region> category = new ArrayList<>();
        category.add(Region.builder().name("Seoul").build());*/

        return categories;
    }

    public Category addCategory(String name) {
        Category category = Category.builder().name("Korean Food").build();

        categoryRepository.save(category);
        return category;
    }
}

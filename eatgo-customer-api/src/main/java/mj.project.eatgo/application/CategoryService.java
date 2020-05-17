package mj.project.eatgo.application;

import mj.project.eatgo.domain.Category;
import mj.project.eatgo.domain.CategoryRepository;
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
}

package com.phat_store_mvc.services.category;

import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllOrderById() {
//       return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return categoryRepository.findAllByOrderById();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id, String name) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Category category = categoryOptional.get();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteById(Integer id) {
       if (categoryRepository.findById(id).isPresent()) {
           categoryRepository.deleteById(id);
           return true;
       }
       return false;
    }
}

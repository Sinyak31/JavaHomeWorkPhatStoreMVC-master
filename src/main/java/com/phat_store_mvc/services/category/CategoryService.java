package com.phat_store_mvc.services.category;

import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.services.DataService;

import java.util.List;

public interface CategoryService extends DataService<Category> {
    @Override
    List<Category> getAll();

    @Override
    Category getById(Integer id);

    List<Category> getAllOrderById();

    @Override
    Category save(Category category);

    @Override
    Category update(Integer id, String name);

    @Override
    boolean deleteById(Integer id);
}

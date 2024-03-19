package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.goods.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByOrderById();
}

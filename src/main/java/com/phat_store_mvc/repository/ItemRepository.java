package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.goods.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByOrderByIdAsc();

    List<Item> findAllByCategoryId(Integer id);
}

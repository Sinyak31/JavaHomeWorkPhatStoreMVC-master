package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.goods.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findByOrderByIdAsc();
}

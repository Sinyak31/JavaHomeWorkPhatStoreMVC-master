package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.goods.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

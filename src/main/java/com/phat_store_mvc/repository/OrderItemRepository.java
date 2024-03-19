package com.phat_store_mvc.repository;

import com.phat_store_mvc.model.goods.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}

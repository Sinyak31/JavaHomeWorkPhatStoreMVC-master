package com.phat_store_mvc.services.order_item;

import com.phat_store_mvc.model.goods.OrderItem;
import com.phat_store_mvc.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getById(Integer id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(Integer id, String name) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (orderItemRepository.findById(id).isPresent()) {
            orderItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.phat_store_mvc.services.order;

import com.phat_store_mvc.model.goods.Order;
import com.phat_store_mvc.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, String name) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

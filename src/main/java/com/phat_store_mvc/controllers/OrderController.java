package com.phat_store_mvc.controllers;

import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.model.goods.Order;
import com.phat_store_mvc.model.goods.OrderItem;
import com.phat_store_mvc.model.order_attributes.OrderStatus;
import com.phat_store_mvc.services.item.ItemService;
import com.phat_store_mvc.services.order.OrderService;
import com.phat_store_mvc.services.order_item.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user/order")
public class OrderController {
    private OrderService orderService;
    private OrderItemService orderItemService;
    private ItemService itemService;

    @PostMapping("/add")
    public String add(Integer itemId, Integer amount, Integer orderId) {
        Item item = itemService.getById(itemId);
        Order order = orderService.getById(orderId);
        OrderItem orderItem = OrderItem.builder()
                .amount(amount)
                .item(item)
                .order(order)
                .build();

        orderItemService.save(orderItem);
        return "redirect:/";
    }

    @PostMapping("/pay/{id}")
    public String pay(@PathVariable Integer id) {
        Order orderToPay = orderService.getById(id);
        orderToPay.setStatus(OrderStatus.ПЕРЕДАН_В_ДОСТАВКУ);
        orderToPay.setIsPaid(true);
        orderService.save(orderToPay);

        Order order = Order.builder()
                .status(OrderStatus.КОРЗИНА)
                .build();
        orderService.save(order);
        return "redirect:/";
    }
}

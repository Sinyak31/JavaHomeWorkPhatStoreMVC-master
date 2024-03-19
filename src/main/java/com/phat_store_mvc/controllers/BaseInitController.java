package com.phat_store_mvc.controllers;

import com.phat_store_mvc.model.goods.Order;
import com.phat_store_mvc.model.order_attributes.OrderStatus;
import com.phat_store_mvc.services.BaseInitService;
import com.phat_store_mvc.services.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generate")
@AllArgsConstructor
public class BaseInitController {
    private BaseInitService baseInitService;
    private OrderService orderService;

    @GetMapping("/")
    public String baseInit() {
        baseInitService.brandInit();
        baseInitService.categoryInit();
        baseInitService.itemInit();
        baseInitService.check();
        return "redirect:/";
    }

    @GetMapping("/order")
    public String orderInit() {
        Order order = Order.builder()
                .status(OrderStatus.КОРЗИНА)
                .build();

        orderService.save(order);
        return "redirect:/";
    }
}

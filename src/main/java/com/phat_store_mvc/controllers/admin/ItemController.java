package com.phat_store_mvc.controllers.admin;

import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.services.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin/items")
public class ItemController {
    private ItemService itemService;

    @PostMapping("/add")
    public String add(Item item) {
        itemService.save(item);
        return "redirect:/admin/item";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Item item) {
        try {
            itemService.save(item);
        } catch (RuntimeException e) {
            log.error("При сохранении товара указан некорректный атрибут");
        }
        return "redirect:/admin/item";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        itemService.deleteById(id);
        return "redirect:/admin/item";
    }
}

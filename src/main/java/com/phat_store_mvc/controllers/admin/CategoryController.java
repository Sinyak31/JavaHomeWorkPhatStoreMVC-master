package com.phat_store_mvc.controllers.admin;

import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.services.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin/categories")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("/add")
    public String add(Category category) {
      categoryService.save(category);
        return "redirect:/admin/category";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @RequestParam String name) {
        try {
            categoryService.update(id, name);
        } catch (RuntimeException e) {
            log.error("Категории с указанным id не существует");
        }
        return "redirect:/admin/category";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }

}

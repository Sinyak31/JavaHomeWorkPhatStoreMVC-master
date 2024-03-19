package com.phat_store_mvc.controllers.admin;

import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.services.brand.BrandService;
import com.phat_store_mvc.services.category.CategoryService;
import com.phat_store_mvc.services.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminViewController {
    private CategoryService categoryService;
    private BrandService brandService;
    private ItemService itemService;

    @GetMapping("/category")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getAllOrderById();
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categories);
        return "/pages/admin/admin";
    }

    @GetMapping("/brand")
    public String getBrands(Model model) {
        List<Brand> brands = brandService.getAllOrderById();
        model.addAttribute("brand", new Brand());
        model.addAttribute("brands", brands);
        return "/pages/admin/admin";
    }

    @GetMapping("/item")
    public String getItems(Model model) {
        List<Item> items = itemService.getAllOrderById();
        model.addAttribute("item", new Item());
        model.addAttribute("itemForSave", new Item());
        model.addAttribute("items", items);
        return "/pages/admin/admin";
    }
}

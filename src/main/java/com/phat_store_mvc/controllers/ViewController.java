package com.phat_store_mvc.controllers;

import com.phat_store_mvc.dto.CategoryDTO;
import com.phat_store_mvc.dto.ItemMapDTO;
import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.model.item_attributes.Color;
import com.phat_store_mvc.model.item_attributes.Sex;
import com.phat_store_mvc.model.item_attributes.Size;
import com.phat_store_mvc.services.brand.BrandService;
import com.phat_store_mvc.services.category.CategoryService;
import com.phat_store_mvc.services.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ViewController {
    private CategoryService categoryService;
    private BrandService brandService;
    private ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {
        List<CategoryDTO> categories = new ArrayList<>() {{categoryService.getAllOrderById().forEach(category -> add(new CategoryDTO(category)));}};
        List<String> brands = brandService.getAllOrderById().stream().map(Brand::getName).toList();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        return "/pages/ui/home";
    }

    @GetMapping("/search")
    public String searchPortal(Model model) {
        List<String> categories = categoryService.getAllOrderById().stream().map(Category::getName).toList();
        List<String> brands = brandService.getAllOrderById().stream().map(Brand::getName).toList();
        List<String> colors = Arrays.stream(Color.values()).map(Color::name).toList();
        List<String> sex = Arrays.stream(Sex.values()).map(Sex::name).toList();
        Map<String, List<String>> sizes = Arrays.stream(Size.values())
                .collect(Collectors.toMap(Size::name, Size::getSizes));

        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        model.addAttribute("colors", colors);
        model.addAttribute("sex", sex);
        model.addAttribute("sizes", sizes);
        return "/pages/search/search";
    }

    @GetMapping("/admin")
    public String adminPortal() {
        return "/pages/admin/admin";
    }

    @GetMapping("/category/{id}")
    public String category(Model model, @PathVariable Integer id) {
        model.addAttribute("category", categoryService.getById(id).getName());
        model.addAttribute("items",  ItemMapDTO.fromEntityList(itemService.getAllByCategoryId(id)));
        return "/pages/ui/category";
    }
}

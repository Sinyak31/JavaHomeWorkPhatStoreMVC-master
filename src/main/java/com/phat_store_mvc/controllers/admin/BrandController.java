package com.phat_store_mvc.controllers.admin;

import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.services.brand.BrandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin/brands")
public class BrandController {
    private BrandService brandService;

    @PostMapping("/add")
    public String add(Brand brand) {
        brandService.save(brand);
        return "redirect:/admin/brand";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @RequestParam String name) {
        try {
            brandService.update(id, name);
        } catch (RuntimeException e) {
            log.error("Бренд с указанным id не существует");
        }
        return "redirect:/admin/brand";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        brandService.deleteById(id);
        return "redirect:/admin/brand";
    }
}

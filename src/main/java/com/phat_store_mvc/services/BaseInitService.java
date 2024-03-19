package com.phat_store_mvc.services;

import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.model.goods.Category;
import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.model.item_attributes.Color;
import com.phat_store_mvc.model.item_attributes.Sex;
import com.phat_store_mvc.model.item_attributes.Size;
import com.phat_store_mvc.services.brand.BrandService;
import com.phat_store_mvc.services.category.CategoryService;
import com.phat_store_mvc.services.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class BaseInitService {
    private BrandService brandService;
    private CategoryService categoryService;
    private ItemService itemService;

    public void brandInit() {
        List<String> brands = List.of("Kangol", "Proclub", "Novesta", "Pinko", "Hublot");
        brands.forEach(brand -> brandService.save(new Brand(brand)));
    }

    public void categoryInit() {
        List<String> categories = List.of("Головные уборы", "Одежда", "Обувь", "Сумки", "Аксессуары", "Творчество");
        categories.forEach(category -> categoryService.save(new Category(category)));
    }

    public void itemInit() {
        String path = "items.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String temp;
            int index = 1;

            while ((temp = br.readLine()) != null) {
                saveItems(buildFromString(temp), index);
                index++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Item buildFromString(String str) {
        String[] arr = str.substring(0, str.length() - 2).split(", ");
        return Item.builder()
                .model(arr[2])
                .sex(Sex.UNISEX)
                .price(Integer.parseInt(arr[3]))
                .build();
    }

    public void saveItems(Item item, int index) {
        Arrays.stream(Color.values()).forEach(color -> {
            item.setColor(color);
            if (index <= 12) {
                saveHats(item);
            } else if (index <= 23) {
                saveClothes(item);
            } else {
                saveShoes(item);
            }
        });
    }

    private void saveHats(Item hat) {
        Size.HATS.getSizes().forEach(size -> {
            Item itemToSave = Item.builder()
                    .model(hat.getModel())
                    .color(hat.getColor())
                    .sex(hat.getSex())
                    .price(hat.getPrice())
                    .size(size)
                    .build();
            saveItem(itemToSave, 1);
        });
    }

    private void saveClothes(Item clothes) {
        Size.CLOTHES.getSizes().forEach(size -> {
            Item itemToSave = Item.builder()
                    .model(clothes.getModel())
                    .color(clothes.getColor())
                    .sex(clothes.getSex())
                    .price(clothes.getPrice())
                    .size(size)
                    .build();
            saveItem(itemToSave, 2);
        });
    }

    private void saveShoes(Item shoes) {
        Size.SHOES.getSizes().forEach(size -> {
            Item itemToSave = Item.builder()
                    .model(shoes.getModel())
                    .color(shoes.getColor())
                    .sex(shoes.getSex())
                    .price(shoes.getPrice())
                    .size(size)
                    .build();
            saveItem(itemToSave, 3);
        });
    }

    private void saveItem(Item item, int index) {
        item.setBrand(brandService.getById(index));
        item.setCategory(categoryService.getById(index));
        item.setAmount((new Random().nextInt(0, 15)));
        itemService.save(item);
    }

    public void check() {
        List<Item> all = itemService.getAll();

        Brand kangol = brandService.getById(1);
        System.out.println(all.stream()
                .filter(i -> i.getBrand() == kangol)
                .toList()
                .size());

        Brand proclub = brandService.getById(2);
        System.out.println(all.stream()
                .filter(i -> i.getBrand() == proclub)
                .toList()
                .size());

        Brand novesta = brandService.getById(3);
        System.out.println(all.stream()
                .filter(i -> i.getBrand() == novesta)
                .toList()
                .size());
    }
}

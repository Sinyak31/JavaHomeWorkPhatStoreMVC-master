package com.phat_store_mvc.dto;

import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.model.item_attributes.Color;
import com.phat_store_mvc.model.item_attributes.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private Integer id;
    private String model;
    private Integer amount;
    private Color color;
    private String size;
    private Sex sex;
    private Integer price;
    private String brand;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.model = item.getModel();
        this.amount = item.getAmount();
        this.color = item.getColor();
        this.size = item.getSize();
        this.sex = item.getSex();
        this.price = item.getPrice();
        this.brand = item.getBrand().getName();
    }
}

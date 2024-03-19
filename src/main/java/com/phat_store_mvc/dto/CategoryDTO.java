package com.phat_store_mvc.dto;

import com.phat_store_mvc.model.goods.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

//    static CategoryDTO fromEntity(Category category) {
//        return new CategoryDTO(category.getId(), category.getName());
//    }
}

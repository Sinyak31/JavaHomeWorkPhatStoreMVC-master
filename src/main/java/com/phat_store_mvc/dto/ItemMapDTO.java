package com.phat_store_mvc.dto;

import com.phat_store_mvc.model.goods.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ItemMapDTO {
    private Map<String, List<ItemDTO>> stock;

    public static Map<String, List<ItemDTO>> fromEntityList(List<Item> items) {
        Map<String, List<ItemDTO>> result = new HashMap<>();
        items.forEach(item -> {
            if (result.get(item.getModel()) == null) {
                result.put(item.getModel(), new ArrayList<>());
            }
            result.get(item.getModel()).add(new ItemDTO(item));
        });
        return result;
    }

}

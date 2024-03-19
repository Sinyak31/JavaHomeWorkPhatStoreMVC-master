package com.phat_store_mvc.services.item;

import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.services.DataService;

import java.util.List;

public interface ItemService extends DataService<Item> {
    @Override
    List<Item> getAll();

    @Override
    Item getById(Integer id);

    List<Item> getAllOrderById();

    List<Item> getAllByCategoryId(Integer id);

    @Override
    Item save(Item item);

    @Override
    Item update(Integer id, String name);

    @Override
    boolean deleteById(Integer id);
}

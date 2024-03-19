package com.phat_store_mvc.services.item;

import com.phat_store_mvc.model.goods.Item;
import com.phat_store_mvc.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllOrderById() {
        return itemRepository.findByOrderByIdAsc().stream().limit(10).toList();
    }

    @Override
    public List<Item> getAllByCategoryId(Integer id) {
        return itemRepository.findAllByCategoryId(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Integer id, String name) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Item item = itemOptional.get();
        item.setModel(name);
        return itemRepository.save(item);
    }

    @Override
    public boolean deleteById(Integer id) {
     if (itemRepository.findById(id).isPresent()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

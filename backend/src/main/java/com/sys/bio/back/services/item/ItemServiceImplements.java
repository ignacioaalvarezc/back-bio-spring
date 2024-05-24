package com.sys.bio.back.services.item;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.models.item.Item;
import com.sys.bio.back.repositories.item.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemServiceImplements implements ItemService {

    @Autowired
    private ItemRepository itemRepo;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Override
    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Set<Item> getItems() {
        return new LinkedHashSet<>(itemRepo.findAll());
    }

    @Override
    public Item getItem(Long itemId) {
        return itemRepo.findById(itemId).get();
    }

    @Override
    public void deleteItem(Long itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        itemRepo.delete(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return (List<Item>) itemRepo.findAll();
    }

}

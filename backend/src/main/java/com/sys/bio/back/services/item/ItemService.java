package com.sys.bio.back.services.item;


import com.sys.bio.back.models.item.Item;

import java.util.List;
import java.util.Set;

public interface ItemService {

    Item addItem(Item item);

    Item updateItem(Item item);

    Set<Item> getItems();

    public List<Item> findAll();

    Item getItem(Long itemId);

    void deleteItem(Long itemId);

}

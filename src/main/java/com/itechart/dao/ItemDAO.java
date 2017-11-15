package com.itechart.dao;

import com.itechart.domain.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> getAllItems(int page, int numbers);

    Item getItemById(int id);

    Item getItemByName(String name);

    void deleteItem(Item item);

    void saveItem(Item item);

}

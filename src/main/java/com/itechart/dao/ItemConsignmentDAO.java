package com.itechart.dao;

import com.itechart.domain.ItemConsignment;

import java.util.List;

public interface ItemConsignmentDAO {

    List<ItemConsignment> getAllItemConsignments(int page, int numbers);

    ItemConsignment getItemConsignmentById(int id);

    void deleteItemConsignment(ItemConsignment itemConsignment);

    void saveItemConsignment(ItemConsignment itemConsignment);

}

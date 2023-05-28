package com.jennybonato.catalog.service;

import com.jennybonato.catalog.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> get();

    Item get(Long id);

    void save(Item item);

    void delete(Long id);
}

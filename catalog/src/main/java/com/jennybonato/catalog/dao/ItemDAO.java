package com.jennybonato.catalog.dao;

import com.jennybonato.catalog.model.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> get();

    Item get(Long id);

    void save(Item category);

    void delete(Long id);
}

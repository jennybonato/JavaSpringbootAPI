package com.jennybonato.catalog.service;

import com.jennybonato.catalog.dao.ItemDAO;
import com.jennybonato.catalog.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImplementation implements ItemService{
    
    @Autowired
    private ItemDAO itemDAO;

    @Transactional
    @Override
    public List<Item> get () {
        return itemDAO.get();
    }

    @Transactional
    @Override
    public Item get (Long id) {
        return itemDAO.get(id);
    }

    @Transactional
    @Override
    public void save (Item item) {
        itemDAO.save(item);
    }

    @Transactional
    @Override
    public void delete (Long id) {
        itemDAO.delete(id);
    }

}

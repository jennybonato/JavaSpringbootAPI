package com.jennybonato.catalog.controller;

import com.jennybonato.catalog.model.Item;
import com.jennybonato.catalog.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public List<Item> get(){
        return itemService.get();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Long id){
        Item item = itemService.get(id);
        if(item == null) {
            throw new RuntimeException("Item with id " + id + " was not found");
        }
        return item;
    }

    @PostMapping("")
    public Item create(@RequestBody Item item){
        itemService.save(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        itemService.delete(id);
        return "Item has beed deleted with id " + id;
    }

    @PutMapping("")
    public Item update(@RequestBody Item item){
        itemService.save(item);
        return item;
    }
}

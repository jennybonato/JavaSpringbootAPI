package com.jennybonato.catalog.service;

import java.util.List;

import com.jennybonato.catalog.dao.CategoryDAO;
import com.jennybonato.catalog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImplementation implements CategoryService{
    
    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    @Override
    public List<Category> get () {
        return categoryDAO.get();
    }

    @Transactional
    @Override
    public Category get (Long id) {
        return categoryDAO.get(id);
    }

    @Transactional
    @Override
    public void save (Category category) {
        categoryDAO.save(category);
    }

    @Transactional
    @Override
    public void delete (Long id) {
        categoryDAO.delete(id);
    }

}

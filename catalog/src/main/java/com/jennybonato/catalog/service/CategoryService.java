package com.jennybonato.catalog.service;

import java.util.List;
import com.jennybonato.catalog.model.Category;

public interface CategoryService {
    List<Category> get();

    Category get(Long id);

    void save(Category category);

    void delete(Long id);
}

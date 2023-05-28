package com.jennybonato.catalog.dao;

import java.util.List;
import com.jennybonato.catalog.model.Category;

public interface CategoryDAO {

    List<Category> get();

    Category get(Long id);

    void save(Category category);

    void delete(Long id);
}

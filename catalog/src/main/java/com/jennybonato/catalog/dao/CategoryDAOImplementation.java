package com.jennybonato.catalog.dao;

import java.util.List;
import com.jennybonato.catalog.model.Category;
import jakarta.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

@Repository
public class CategoryDAOImplementation implements CategoryDAO {

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Category> get () {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Category> query = currentSession.createQuery("from Category", Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }

    @Override
    public Category get (Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Category category = currentSession.get(Category.class, id);
        return category;
    }

    @Override
    public void save (Category category) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(category);
    }

    @Override
    public void delete (Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Category category = currentSession.get(Category.class, id);
        currentSession.remove(category);
    }
}

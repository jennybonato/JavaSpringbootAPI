package com.jennybonato.catalog.dao;

import java.util.List;
import com.jennybonato.catalog.model.Item;
import jakarta.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

@Repository
public class ItemDAOImplementation implements ItemDAO {

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Item> get () {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Item> query = currentSession.createQuery("FROM Item", Item.class);
        return query.getResultList();
    }

    @Override
    public Item get (Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Item item = currentSession.get(Item.class, id);
        return item;
    }

    @Override
    public void save (Item item) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(item);
    }

    @Override
    public void delete (Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Item item = currentSession.get(Item.class, id);
        currentSession.remove(item);
    }
}

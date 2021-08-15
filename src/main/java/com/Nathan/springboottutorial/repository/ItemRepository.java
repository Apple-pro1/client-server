package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Item item) {
        entityManager.persist(item);
        return item.getItemId();
    }

    public Item retrieve(Long itemId) {
        Item item = entityManager.find(Item.class, itemId);
        return item;
    }

    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    public void delete(Long itemId) {
        Item item = entityManager.find(Item.class, itemId);
        entityManager.remove(item);
    }
}

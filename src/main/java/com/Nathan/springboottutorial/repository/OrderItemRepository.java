package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(OrderItem orderItem) {
        entityManager.persist(orderItem);
        return orderItem.getId();
    }

    public OrderItem retrieve(Long orderItemId) {
        OrderItem orderItem = entityManager.find(OrderItem.class, orderItemId);
        return orderItem;
    }

    public OrderItem update(OrderItem orderItem) {
        entityManager.merge(orderItem);
        return orderItem;
    }

    public void delete(Long orderItemId) {
        OrderItem orderItem = entityManager.find(OrderItem.class, orderItemId);
        entityManager.remove(orderItem);
    }
}


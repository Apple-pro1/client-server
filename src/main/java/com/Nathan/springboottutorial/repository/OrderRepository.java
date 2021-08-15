package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(Order order) {
        entityManager.persist(order);
        return order.getId();
    }

    public Order retrieve(Long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        return order;
    }

    public Order update(Order order) {
        entityManager.merge(order);
        return order;
    }

    public void delete(Long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        entityManager.remove(order);
    }
}



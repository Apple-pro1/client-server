package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.OrderStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderStatusRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long create(OrderStatus orderStatus) {
        entityManager.persist(orderStatus);
        return orderStatus.getOrderStatusId();
    }

    public OrderStatus retrieve(Long orderStatusId) {
        OrderStatus orderStatus = entityManager.find(OrderStatus.class, orderStatusId);
        return orderStatus;
    }

    public OrderStatus update(OrderStatus orderStatus) {
        entityManager.merge(orderStatus);
        return orderStatus;
    }

    public void delete(Long orderStatusId) {
        OrderStatus orderStatus = entityManager.find(OrderStatus.class, orderStatusId);
        entityManager.remove(orderStatus);
    }
}

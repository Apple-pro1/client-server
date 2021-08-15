package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderStatusRepositoryTest {
    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Test
    @Transactional
    void saveAndFindTest(){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCurrentStatus("preparing");
        orderStatus.setOrder(null);

        Long createdOrderStatusId = orderStatusRepository.create(orderStatus);
        OrderStatus retrievedOrderStatus = orderStatusRepository.retrieve(createdOrderStatusId);

        assertThat(retrievedOrderStatus).isNotNull();
        assertThat(retrievedOrderStatus.getOrderStatusId()).isNotNull();
        assertThat(retrievedOrderStatus.getCurrentStatus()).isEqualTo("preparing");
    }

    @Test
    @Transactional
    void saveAndDeleteTest() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCurrentStatus("preparing");
        orderStatus.setOrder(null);

        Long createdOrderStatusId = orderStatusRepository.create(orderStatus);
        OrderStatus retrievedOrderStatus = orderStatusRepository.retrieve(createdOrderStatusId);
        orderStatusRepository.delete(retrievedOrderStatus.getOrderStatusId());

        retrievedOrderStatus = orderStatusRepository.retrieve(createdOrderStatusId);

        assertThat(retrievedOrderStatus).isNull();
    }

    @Test
    @Transactional
    void saveAndUpdateTest() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCurrentStatus("preparing");
        orderStatus.setOrder(null);

        Long createdOrderStatusId = orderStatusRepository.create(orderStatus);
        OrderStatus retrievedOrderStatus = orderStatusRepository.retrieve(createdOrderStatusId);
        retrievedOrderStatus.setCurrentStatus("shipping");
        OrderStatus updatedOrderStatus = orderStatusRepository.update(retrievedOrderStatus);

        assertThat(updatedOrderStatus).isNotNull();
        assertThat(updatedOrderStatus.getOrderStatusId()).isEqualTo(createdOrderStatusId);
        assertThat(updatedOrderStatus.getCurrentStatus()).isEqualTo("shipping");
        assertThat(updatedOrderStatus.getOrder()).isNull();
    }

    @Test
    void create() {
    }

    @Test
    void retrieve() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
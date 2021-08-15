package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Transactional
    void createTest() {

        Member member = new Member();
        member.setMemberName("aaa");
        Long createdMemberId = memberRepository.create(member);

        Order order = new Order();
        Member retrievedMember = memberRepository.retrieve(createdMemberId);
        order.setMember(retrievedMember);
        retrievedMember.addOrder(order);
        Long createdOrderId = orderRepository.create(order);

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCurrentStatus("cancelled");
        Order retrievedOrder = orderRepository.retrieve(createdOrderId);
        orderStatus.setOrder(retrievedOrder);
        Long createdOrderStatusId = orderStatusRepository.create(orderStatus);

        orderStatus.setOrder(retrievedOrder);

        retrievedOrder.setOrderStatus(orderStatus);
        orderRepository.update(retrievedOrder);


        Item item = new Item();
        item.setItemCost(200.0);
        item.setItemName("MacbookPro");
        Long createdItemId = itemRepository.create(item);

        OrderItem orderItem = new OrderItem();
        Item retrievedItem = itemRepository.retrieve(createdItemId);
        orderItem.setItem(retrievedItem);
        orderItem.setOrder(retrievedOrder);

        orderRepository.update(retrievedOrder);

        Long createdOrderItemId = orderItemRepository.create(orderItem);

        OrderItem orderItem1 = orderItemRepository.retrieve(createdOrderItemId);

        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(orderItem1);

        retrievedOrder.setOrderItems(orderItems);
        orderRepository.update(retrievedOrder);


        Order retrieved = orderRepository.retrieve(createdOrderId);

        assertThat(retrieved).isNotNull();
        assertThat(retrieved.getMember()).isNotNull();
        assertThat(retrieved.getOrderStatus()).isNotNull();
        assertThat(retrieved.getOrderItems()).isNotNull();

        assertThat(retrieved.getId()).isEqualTo((createdOrderId));
        assertThat(retrieved.getMember().getId()).isEqualTo((createdMemberId));
        assertThat(retrieved.getMember().getMemberName()).isEqualTo("aaa");

        assertThat(retrieved.getOrderItems().size()).isEqualTo(1);
        assertThat(retrieved.getOrderItems().get(0).getOrder().getId()).isEqualTo(createdOrderId);
        assertThat(retrieved.getOrderItems().get(0).getId()).isEqualTo(createdOrderItemId);
        assertThat(retrieved.getOrderItems().get(0).getItem()).isNotNull();
        assertThat(retrieved.getOrderItems().get(0).getItem().getItemName()).isEqualTo("MacbookPro");
        assertThat(retrieved.getOrderItems().get(0).getItem().getItemCost()).isEqualTo(200.0);

        assertThat(retrieved.getOrderStatus().getCurrentStatus()).isEqualTo("cancelled");
        assertThat(retrieved.getOrderStatus().getOrderStatusId()).isEqualTo(createdOrderStatusId);

        log.info("order = {}", retrieved);



    }


}
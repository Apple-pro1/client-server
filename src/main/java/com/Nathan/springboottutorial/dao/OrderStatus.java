package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
@Getter @Setter
public class OrderStatus {
    @Id @GeneratedValue
    @Column(name = "order_status_id")
    private Long orderStatusId;


    @Column(name = "current_status")
    private String currentStatus;

    @OneToOne(mappedBy = "orderStatus")
    private Order order;
}

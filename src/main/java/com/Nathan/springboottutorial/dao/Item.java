package com.Nathan.springboottutorial.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Getter @Setter
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;


    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_cost")
    private Double itemCost;


}

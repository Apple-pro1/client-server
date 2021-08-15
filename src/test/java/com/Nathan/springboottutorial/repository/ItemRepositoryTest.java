package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @Transactional
    void create() {

        Item item = new Item();
        item.setItemName("iPhone");
        item.setItemCost(400.0);

        Long createdItemId = itemRepository.create(item);
        Item retrievedItem = itemRepository.retrieve(createdItemId);


        assertThat(retrievedItem).isNotNull();
        assertThat(retrievedItem.getItemCost()).isEqualTo(400.0);
        assertThat(retrievedItem.getItemName()).isEqualTo("iPhone");
    }

    @Test
    @Transactional
    void saveAndDeleteTest() {
        Item item = new Item();
        item.setItemName("iPhone");
        item.setItemCost(400.0);


        Long createdItemId = itemRepository.create(item);
        Item retrieveItem = itemRepository.retrieve(createdItemId);
        itemRepository.delete(retrieveItem.getItemId());

        Item retrievedItem2 = itemRepository.retrieve(createdItemId);


        assertThat(retrievedItem2).isNull();
    }

    @Test
    @Transactional
    void saveAndUpdateTest() {

        Item item = new Item();
        item.setItemName("iPhone");
        item.setItemCost(400.0);


        Long createdItemId = itemRepository.create(item);
        Item retrievedItem = itemRepository.retrieve(createdItemId);

        retrievedItem.setItemCost(500.0);
        Item updatedItem = itemRepository.update(retrievedItem);

        assertThat(updatedItem).isNotNull();
        assertThat(updatedItem.getItemCost()).isEqualTo(500.0);
        assertThat(updatedItem.getItemName()).isEqualTo("iPhone");
    }

    @Test
    @Transactional
    void saveAnddeleteTest() {

        Item item = new Item();
        item.setItemName("iPhone");
        item.setItemCost(400.0);

        Long createdItemId = itemRepository.create(item);
        Item retrievedItem = itemRepository.retrieve(createdItemId);
        itemRepository.delete(retrievedItem.getItemId());

        Item retrievedItem2 = itemRepository.retrieve(createdItemId);

        assertThat(retrievedItem2).isNull();
    }
}
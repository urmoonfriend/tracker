package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.util.List;

public interface Store {
    Item add(Item item);

    boolean replace(Integer id, Item item);

    boolean delete(Integer id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(Integer id);
}
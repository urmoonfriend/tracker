package ru.job4j.tracker;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Item {
    private int id;
    private String name;
    private final LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }
}

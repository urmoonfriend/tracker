package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String date = created.format(formatter);
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + date
                + '}';
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item();
        item.setName("item_" + LocalDateTime.now().toString());
        hbmTracker.add(item);
        System.out.printf("added item: {%s}\n", item.toString());
        Item findItem = hbmTracker.findById(item.getId());
        System.out.printf("found Item: {%s}\n", findItem.toString());
    }
}

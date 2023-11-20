package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("item_" + LocalDateTime.now().toString());
        HbmTracker hbmTracker = new HbmTracker();
        hbmTracker.add(item);
        System.out.printf("added item: {%s}\n", item.toString());
        var findItem = hbmTracker.findById(item.getId());
        System.out.printf("found Item: {%s}\n", findItem.toString());
    }
}

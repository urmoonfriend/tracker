package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("item1");
        HbmTracker hbmTracker = new HbmTracker();
        hbmTracker.add(item);
    }
}

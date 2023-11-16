package ru.job4j.tracker;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.models.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @BeforeEach
    @AfterEach
    public void clear() throws Exception {
        try (var tracker = new HbmTracker()) {
            for (Item item : tracker.findAll()) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            item = tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenSuccess() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item item2 = new Item();
            item2.setName("test2");
            tracker.replace(item.getId(), item2);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item2.getName());
        }
    }

    @Test
    public void whenFindAllItemThenSuccess() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findAll();
            assertThat(result.size()).isEqualTo(1);
        }
    }

    @Test
    public void whenDeleteItemThenSuccess() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            boolean result = tracker.delete(item.getId());
            assertThat(result).isEqualTo(true);
        }
    }

    @Test
    public void whenFindByNameItemThenSuccess() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> foundedItems = tracker.findByName(item.getName());
            foundedItems.forEach(
                    foundedItem -> assertThat(item.getName()).isEqualTo(foundedItem.getName())
            );
        }
    }

}

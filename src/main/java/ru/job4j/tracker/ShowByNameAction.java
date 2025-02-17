package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.util.List;

public class ShowByNameAction implements UserAction {

    private final Output out;

    public ShowByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
            result = true;
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return result;
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

public class ShowByIdAction implements UserAction {

    private final Output out;

    public ShowByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
            result = true;
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return result;
    }
}

package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
                )
        );
    }

    @Test
    public void whenAddItemTestOutput() {
        Output out = new StubOutput();
        String name = "Item name";
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item item = tracker.findByName(name)[0];
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Exit Program" + ln
                        + "=== Create a new Item ===" + ln
                        + "Добавленная заявка: " + item + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }
}

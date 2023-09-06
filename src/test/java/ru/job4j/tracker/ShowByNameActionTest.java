package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowByNameActionTest {
    private ShowByNameAction showByNameAction;
    private Tracker tracker;

    @BeforeEach
    public void initServices() {
        Output out = new StubOutput();
        showByNameAction = new ShowByNameAction(out);
        tracker = mock(Tracker.class);
    }

    @Test
    public void whenRequestThenFound() {
        var item1 = new Item("test1");
        List<Item> items = List.of(item1);
        when(tracker.findByName(any())).thenReturn(items);
        Input in = new StubInput(
                new String[]{"test1"}
        );
        boolean resutl = showByNameAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(true);
    }

    @Test
    public void whenRequestThenNotFound() {
        List<Item> items = new ArrayList<>();
        when(tracker.findByName(any())).thenReturn(items);
        Input in = new StubInput(
                new String[]{"test1"}
        );
        boolean resutl = showByNameAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(false);
    }
}

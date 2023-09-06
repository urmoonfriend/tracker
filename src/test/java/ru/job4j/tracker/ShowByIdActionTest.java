package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowByIdActionTest {

    private ShowByIdAction showByIdAction;
    private Tracker tracker;

    @BeforeEach
    public void initServices() {
        Output out = new StubOutput();
        showByIdAction = new ShowByIdAction(out);
        tracker = mock(Tracker.class);
    }

    @Test
    public void whenRequestThenFound() {
        var item1 = new Item("test1");
        when(tracker.findById(1)).thenReturn(item1);
        Input in = new StubInput(
                new String[]{"1"}
        );
        boolean resutl = showByIdAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(true);
    }

    @Test
    public void whenRequestThenNotFound() {
        when(tracker.findById(1)).thenReturn(null);
        Input in = new StubInput(
                new String[]{"1"}
        );
        boolean resutl = showByIdAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(false);
    }
}

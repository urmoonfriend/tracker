package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    private DeleteAction deleteAction;
    private Tracker tracker;

    @BeforeEach
    public void initServices() {
        Output out = new StubOutput();
        deleteAction = new DeleteAction(out);
        tracker = mock(Tracker.class);
    }

    @Test
    public void whenRequestThenDelete() {
        var item1 = new Item("test1");
        when(tracker.delete(1)).thenReturn(true);
        Input in = new StubInput(
                new String[]{"1"}
        );
        boolean resutl = deleteAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(true);
    }

    @Test
    public void whenRequestThenNotDelete() {
        when(tracker.delete(1)).thenReturn(false);
        Input in = new StubInput(
                new String[]{"1"}
        );
        boolean resutl = deleteAction.execute(in, tracker);
        assertThat(resutl).isEqualTo(false);
    }
}

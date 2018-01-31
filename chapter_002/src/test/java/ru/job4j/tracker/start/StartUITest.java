package ru.job4j.tracker.start;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

public class StartUITest {

    @Test
    public void testWhenAddItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Task1", "Desc1", "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll()[0].getName(), Matchers.is("Task1"));
    }

    @Test
    public void testWhenUpdateItemThenTrackerHasUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Task1", "Desc", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"2", item.getId(), "Task2", "Desc2", "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll()[0].getName(), Matchers.is("Task2"));
    }

    @Test
    public void testWhenDeleteSingleItemThenTrackerHasNotItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Task1", "Desc", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"3", item.getId(), "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll(), Matchers.is(new Item[]{}));
    }

    @Test
    public void testWhenDeleteOneFromTwoItemsThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Task1", "Desc1", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("Task2", "Desc2", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"3", item1.getId(), "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll()[0].getName(), Matchers.is("Task2"));
    }
}
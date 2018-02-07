package ru.job4j.tracker.start;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StartUITest {

    @Test
    public void testWhenAddItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Task1", "Desc1", "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("Task1"));
    }

    @Test
    public void testWhenUpdateItemThenTrackerHasUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Task1", "Desc", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"2", item.getId(), "Task2", "Desc2", "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("Task2"));
    }

    @Test
    public void testWhenDeleteSingleItemThenTrackerHasNotItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Task1", "Desc", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"3", item.getId(), "7"});
        new StartUI(input, tracker).init();
        List<Item> expected = new ArrayList<>();
        Assert.assertThat(tracker.findAll(), Matchers.is(expected));
    }

    @Test
    public void testWhenDeleteOneFromTwoItemsThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Task1", "Desc1", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("Task2", "Desc2", System.currentTimeMillis()));

        Input input = new StubInput(new String[]{"3", item1.getId(), "7"});
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("Task2"));
    }

    @Test
    public void testWhenFindAll() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Task1", "Desc1", 1L));
        Input input = new StubInput(new String[]{"4", "7"});
        new StartUI(input, tracker).init();

        Assert.assertThat(
                new String(out.toByteArray()),
                Matchers.is(new StringBuilder()
                        .append("1. Add a new item")
                        .append(System.lineSeparator())
                        .append("2. Replace item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Show all items")
                        .append(System.lineSeparator())
                        .append("5. Find item by id")
                        .append(System.lineSeparator())
                        .append("6. Find item by name")
                        .append(System.lineSeparator())
                        .append("7. Exit")
                        .append(System.lineSeparator())
                        .append(new StringBuilder(item1.toString()))
                        .append(System.lineSeparator())
                        .append("1. Add a new item")
                        .append(System.lineSeparator())
                        .append("2. Replace item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Show all items")
                        .append(System.lineSeparator())
                        .append("5. Find item by id")
                        .append(System.lineSeparator())
                        .append("6. Find item by name")
                        .append(System.lineSeparator())
                        .append("7. Exit")
                        .append(System.lineSeparator())
                        .toString())
        );
        System.setOut(stdout);
    }
}
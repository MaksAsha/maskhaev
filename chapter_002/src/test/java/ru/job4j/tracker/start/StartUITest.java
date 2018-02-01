package ru.job4j.tracker.start;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
                        .append(System.lineSeparator())
                        .append("Меню:")
                        .append(System.lineSeparator())
                        .append("Нажмите 1 - добавить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 2 - изменить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 3 - удалить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 4 - просмотр всех задач")
                        .append(System.lineSeparator())
                        .append("Нажмите 5 - поиск задачи по имени")
                        .append(System.lineSeparator())
                        .append("Нажмите 6 - поиск задачи по id")
                        .append(System.lineSeparator())
                        .append("Нажмите 7 - выйти из программы")
                        .append(System.lineSeparator())
                        .append("Список задач:")
                        .append(System.lineSeparator())
                        .append(new StringBuilder(item1.toString()))
                        .append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .append("Меню:")
                        .append(System.lineSeparator())
                        .append("Нажмите 1 - добавить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 2 - изменить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 3 - удалить задачу")
                        .append(System.lineSeparator())
                        .append("Нажмите 4 - просмотр всех задач")
                        .append(System.lineSeparator())
                        .append("Нажмите 5 - поиск задачи по имени")
                        .append(System.lineSeparator())
                        .append("Нажмите 6 - поиск задачи по id")
                        .append(System.lineSeparator())
                        .append("Нажмите 7 - выйти из программы")
                        .append(System.lineSeparator())
                        .toString())
        );
        System.setOut(stdout);
    }
}
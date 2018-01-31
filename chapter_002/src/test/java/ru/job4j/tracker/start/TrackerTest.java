package ru.job4j.tracker.start;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

public class TrackerTest {

    Tracker tracker;
    Item item1, item2, item3, item4, item41;

    @Before
    public void setUp() throws Exception {
        tracker = new Tracker();
        item1 = new Item("Item1", "Descr1", 1L);
        item2 = new Item("Item2", "Descr2", 2L);
        item3 = new Item("Item3", "Descr3", 3L);
        item4 = new Item("Item4", "Descr4", 4L);
        item41 = new Item("Item4", "Descr4", 4L);
    }

    @Test
    public void generateId() throws Exception {
    }

    @Test
    public void testFindByIdIfItemExists() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item actual = tracker.findById(item2.getId());
        Item expected = item2;

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testFindByIdIfItemNotExists() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item actual = tracker.findById(item4.getId());
        Item expected = null;

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testFindByNameIfNameExists() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item41);

        Item[] actual = tracker.findByName("Item4");
        Item[] expected = new Item[]{item4, item41};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testFindByNameIfNameNotExists() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] actual = tracker.findByName("Item4");
        Item[] expected = null;

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testFindAllIfItemsExists() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item1, item2, item3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testFindAllIfItemsNotExists() throws Exception {

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{};

        Assert.assertThat(actual, Matchers.is(expected));
    }


    @Test
    public void testAddIfItemNotNull() throws Exception {
        Item actual = tracker.add(item1);
        Item expected = item1;

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIfItemsIndexExceedNotNull() throws Exception {
        for (int i = 0; i < 100; i++) tracker.add(item1);
        tracker.add(item1);//adding 101th item
    }

    @Test
    public void testAddIfItemIsNull() throws Exception {
        Item itemNull = null;

        Item actual = tracker.add(itemNull);
        Item expected = null;

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testReplaceIfIdExists() throws Exception {
        initTestReplace(item2, item4);

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item1, item4, item3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testReplaceIfIdNotExists() throws Exception {
        initTestReplace(item4, item41);

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item1, item2, item3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testDeleteIfIdExists() throws Exception {
        initTestDelete(item2);

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item1, item3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testDeleteIfIdIsNull() throws Exception {
        initTestDelete(item4);

        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item1, item2, item3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    private void initTestReplace(Item itemA, Item itemB) {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.replace(itemA.getId(), itemB);
    }

    private void initTestDelete(Item item) {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item.getId());
    }
}
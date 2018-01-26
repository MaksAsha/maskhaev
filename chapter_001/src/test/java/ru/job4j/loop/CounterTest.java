package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void testAddFromStartOneToFinishTenWithResultOfThirty() throws Exception {
        Counter counter = new Counter();
        Assert.assertThat(counter.add(1, 10), Matchers.is(30));
    }

}
package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void testAddFromStartOneToFinishTenWithResultOfThirty() throws Exception {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        Assert.assertThat(result, Matchers.is(expected));
    }

}
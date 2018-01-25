package ru.job4j.max;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxTest {

    Max max;

    @Before
    public void setUp() {
        max = new Max();
    }

    @Test
    public void testMaxFromTwo() throws Exception {
        Assert.assertThat(max.getMax(1, 2), Matchers.is(2));
    }

    @Test
    public void testMaxFromThree() throws Exception {
        Assert.assertThat(max.getMaxFromThree(1, 2, 3), Matchers.is(3));
    }
}
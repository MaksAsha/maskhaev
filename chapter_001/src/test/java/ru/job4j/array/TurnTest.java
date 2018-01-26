package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnTest {

    Turn turn;

    @Before
    public void setUp() {
        turn = new Turn();
    }

    @Test
    public void testBackUnEven() throws Exception {
        int[] data = new int[]{0, 1, 2, 3, 4};
        int[] result = turn.back(data);
        int[] expected = new int[]{4, 3, 2, 1, 0};
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testBackEven() throws Exception {
        int[] data = new int[]{5, 4, 3, 2};
        int[] result = turn.back(data);
        int[] expected = new int[]{2, 3, 4, 5};
        Assert.assertThat(result, Matchers.is(expected));
    }
}